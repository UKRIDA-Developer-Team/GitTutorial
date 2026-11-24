# AGENTS.md

Guidance for AI coding agents working in this repository. Read this before making changes.

## Project summary

GitTutorial is an interactive learning platform for Git, GitHub, and shell usage. Content is written once in `courses/` and rendered into multiple formats (text, visual, quiz, flashcards, game, video/audio, wiki) by renderers in `shared/`. The site is an Astro project in `site/`.

Lessons are composed of typed, self-contained blocks. Blocks are the reusable unit: a lesson renders all of them, and a brief (such as the Nutshell) composes a subset. Briefs are not courses and contain no new objectives, quizzes, or scenarios.

## Key principles

1. **Content is the source of truth.** Never hand-edit generated output (`dist/`, the wiki, or rendered pages). Change the source in `courses/` or the renderer in `shared/`.
2. **One concept, one objective.** Lessons define objectives in `objectives.yaml`; quizzes, flashcards, and scenarios reference those IDs. A quiz may point to a lesson and use its objectives, or stand alone with its own. Don't create a second definition of a concept.
3. **Renderers don't know about the site layout.** Keep site-specific logic (navigation, theme, routing) in `site/`, not in `shared/renderers/`.
4. **The sandbox grades state, not commands.** A scenario passes when the repository state matches `goal`, regardless of which commands produced it. Don't add grading based on exact command sequences.
5. **Keep the sandbox to taught commands.** The engine implements only the commands listed in a scenario's `allowed_commands` and the course's command set. Don't wire it to the real Git binary or the GitHub API.
6. **Pages is static.** Progress is saved in `localStorage` with JSON export and import. Don't add a backend or require authentication unless the maintainer asks for it.
7. **Platform differences go inline.** Shell courses are separate from the Git course. Use `unix:` and `windows:` variants within a lesson only for commands that differ. Don't duplicate whole lessons.
8. **Blocks are the reusable unit.** Lessons and briefs compose typed blocks. A brief is not a second course. Compose, don't copy: each block has one canonical definition.
9. **Content first.** Define and validate content before building renderers. Rendering is a separate workstream.

## Repository layout

```
courses/      content: lessons composed of typed blocks, briefs, objectives, quizzes, scenarios
shared/       renderers/ and components/ (framework islands)
site/         Astro project: pages, layouts, config
scripts/      build helpers, content validation, wiki export
tests/        engine and content tests
.github/      workflows: ci.yml, deploy.yml, wiki.yml
dist/         generated output, git-ignored, never edit
```

## Commands

Run these before proposing changes as complete:

```bash
npm install       # install dependencies
npm run dev       # local dev server
npm test          # engine and content tests (required to pass)
npm run build     # produce dist/ (required to pass)
```

If a content validation script exists (`npm run validate`), run it after editing anything in `courses/`.

## Content rules

- Each lesson folder contains `lesson.md` and `objectives.yaml`, plus optional media. Quizzes, scenarios, and scripts are separate artifacts; they are not required for a lesson and a lesson never links to them. `lesson.md` is composed of typed blocks; see [Content blocks](#content-blocks).
- Every core lesson must include one `Idea` and one `Explain`. Add `Commands` when the lesson teaches commands, and `Diagram` when a visual model helps. `Warning` and `Question` are optional. The capstone is exempt until its format is defined.
- A brief lives in `courses/<course>/briefs/<name>/` and contains `brief.yaml` plus optional `intro.md` and `outro.md`. It has no `objectives.yaml`, `quiz.yaml`, or `scenario.yaml`.
- Briefs add no new teaching content. If a brief needs a concept that no core lesson covers, add it to a core lesson first.
- Every objective referenced by a quiz, scenario, or flashcard must exist in that artifact's source `objectives.yaml`. A quiz that points to a lesson uses that lesson's objectives; a standalone quiz defines its own. Validation should fail otherwise.
- Object IDs use lowercase dot notation (for example, `git.branching.recover-detached`).
- Scenario `start` and `goal` states must be valid: every branch and HEAD must point to a commit that exists, and commit parents must exist.
- Scenario `allowed_commands` must only list commands the sandbox engine implements.
- Each scenario needs at least one hint, ordered from least to most revealing.
- Lesson folders are numbered (`00-`, `01-`) to set order. Don't rename existing folders without updating links.
- Write in plain English. Don't add a lesson's content to the wiki manually.

## Content blocks

A block is a typed, self-contained section of a lesson. It is the smallest reusable teaching unit. Lessons render all blocks; briefs compose a subset.

### Block syntax

Use a level-2 heading with a type prefix and a stable ID:

```md
## Idea: A branch is a label {#branch-is-a-label}

A branch is a name that points at a commit.

## Commands {#branch-commands}

| Command | What it does |
| --- | --- |
| `git branch feature` | Create a label at the current commit |
| `git switch feature` | Move HEAD and update the working tree |
```

- The lesson title is level 1.
- Blocks are level-2 headings. A block ends at the next level-2 heading.
- The type is the heading prefix before the colon, or the whole heading when there is no colon. The ID is the `{#...}` value.
- Block IDs are lowercase kebab-case, descriptive, and unique within the lesson. Use `branch-is-a-label`, not `b1` or `idea2`.
- Reference a block as `<lesson-folder>#<block-id>`, for example `04-branches-and-head#branch-is-a-label`.
- Never rename a block ID without updating every reference.
- Non-block level-2 headings are allowed for narrative, but they are not extractable.

### Approved block types

| Type | Purpose | Required in core lessons |
| --- | --- | --- |
| `Idea` | One-sentence takeaway | Yes |
| `Explain` | Short explanation | Yes |
| `Diagram` | Visual model with alt text | When a visual helps |
| `Commands` | Command table | When the lesson teaches commands |
| `Example` | Concrete walkthrough | Optional |
| `Warning` | Common mistake | Optional |
| `Question` | Pose a teaching question and answer it inline; not an assessment | Optional |
| `Recap` | One-line checklist item | Optional |

Do not add, remove, or rename a block type without maintainer approval. A command table may list several commands, but it must serve one teaching idea. If a block teaches two ideas, split it.

A `Question` block is teaching content. It poses a concrete situation and answers it in the same block. It is not a quiz: it has no hidden answer, scoring, or objective.

### Briefs

A brief is a composition of blocks, not a course. The Nutshell is the first brief; a course may have more. Briefs:

- contain no objectives, quizzes, or scenarios;
- add no new teaching concepts;
- draw only from lessons in the same course;
- select any subset of the course's lessons, including the whole course;
- select blocks by lesson and type, or by explicit block ID;
- keep `intro.md` and `outro.md` to orientation and summary only.

A course may have one brief, several focused briefs, or a combined brief plus split parts. Splitting or combining briefs is a composition change, not a schema change. Do not assume a course has exactly one brief or that a brief covers a fixed lesson range. The site decides whether to present one brief, several, or a chooser; the manifest does not name a layout or navigation path.

A brief manifest looks like this:

```yaml
id: nutshell
title: Git & GitHub in a Nutshell
course: git-github

include:
  lessons:
    - 00-version-control-basics
    - 01-git-basics-commits
    - 02-git-basics-map
    - 03-first-commit
    - 04-branches-and-head
    - 05-merging-and-conflicts
    - 06-undo-and-recovery
    - 07-remotes-are-copies
    - 08-pull-requests
    - 09-rebase-for-clean-history
    # 10-14 are under-the-hood; add here when needed.
    - 15-auth-and-identity
    - 16-forks-and-upstream
    - 17-issues-and-planning
    - 18-review-and-merge-at-scale
    - 19-actions-and-ci
    - 20-releases-tags-and-security
  blocks: [idea, explain, diagram, commands, warning, question]

intro: intro.md
outro: outro.md
```

Block order follows lesson order; the type list is a filter. A lesson entry may be a folder name or an object that narrows the block types for that lesson:

```yaml
include:
  lessons:
    - 01-git-basics-commits
    - lesson: 16-forks-and-upstream
      blocks: [idea, explain, warning]
  blocks: [idea, explain, diagram, commands, warning, question]
```

An entry without its own `blocks` inherits the brief-level filter. `include.briefs`, `exclude`, and ordering metadata are possible later extensions, not part of the schema yet.

### Media

- Put block-specific media in `media/blocks/<block-id>/`.
- Put shared diagrams in `media/diagrams/<id>/`.
- Every diagram needs alt text.
- A block's media belongs to the block; don't swap it per output.

### Block guardrails

1. **Content before rendering.** Author and validate blocks, lessons, and briefs before any brief renderer exists. A content PR must not depend on a rendering change.
2. **One canonical block.** Each block is defined once, in its lesson. Lessons and briefs reference it. Never copy block text into a brief or another lesson.
3. **A block is not a lesson.** Blocks have no completion state, prerequisites, objectives, quizzes, or scenarios. They are teaching content only.
4. **Self-contained.** A block must make sense on its own. No "as we saw above," "the previous section," or unexplained pronouns. Define terms in the block.
5. **One idea per block.** If a block teaches two ideas, split it. Do not split a single explanation into sentence-level fragments.
6. **Stable IDs.** Use lowercase kebab-case, descriptive, and unique within the lesson. Never rename a block without updating every brief and reference.
7. **Fixed vocabulary.** Only the approved block types. Adding, removing, or renaming a type is a schema change and needs maintainer approval.
8. **Core lessons stand alone from the brief, not from the course sequence.** A learner must never need the brief to understand a lesson. A lesson may assume earlier lessons in the same course.
9. **Briefs add no teaching content.** Intro and outro may orient or summarize. They must not introduce a new concept, command, or objective.
10. **Briefs have no assessments.** No `objectives.yaml`, `quiz.yaml`, or `scenario.yaml` in a brief.
11. **No layout language.** Don't write "left," "right," "slide," "video," "click," or "on the next page." Content describes the concept, not the presentation.
12. **Media is part of the block.** Put per-block assets in `media/blocks/<block-id>/`; include alt text; don't swap media per output.
13. **Don't block-ify everything.** Prose that only works in one lesson stays prose. Blocks are for reusable teaching units, not every paragraph.
14. **Concept first, application later.** The lesson that introduces a concept owns its canonical explanation. Later lessons may restate it in a one-line `Recap`, then apply it with commands or examples. Do not copy the full block or create a second definition. If the same block is genuinely needed in two lessons, promote it to a shared block instead of copying it; that is a schema change.
15. **Platform variants stay inline.** Use `unix:`/`windows:` variants inside a block. Don't create platform-specific blocks.
16. **Never hand-edit generated output.** Briefs and pages are composed. Edit the block or manifest, then regenerate.
17. **Validate before merging.** Block type, ID uniqueness, required blocks, brief references, media alt text, and lesson objectives must pass validation.
18. **Briefs are not mutually exclusive.** The same block may appear in several briefs. Splitting or combining briefs changes manifests, not blocks.
19. **Presentation is not composition.** A brief manifest does not name a layout, route, or navigation path. The site decides whether to show one brief, several, or a chooser.
20. **Assessments are separate artifacts.** A lesson exists without a quiz. A quiz may point to a lesson and use its objectives, or stand alone and define its own. A lesson never links to a quiz.

## Code rules

- Use TypeScript for `shared/` and `scripts/`.
- Content first. Don't build a brief renderer or other presentation layer until the block model is validated on at least two lessons.
- Keep content and rendering changes in separate PRs.
- Write tests for every engine command and every renderer's core logic in `tests/`.
- Renderers accept data and return output. They shouldn't read files from `courses/` directly; the build passes data in.
- Block extraction and brief composition are build concerns. They get tests when implemented; renderers still receive resolved data.
- Brief composition is data. Read every `briefs/*/brief.yaml`; never hard-code a lesson range, a single brief, or the Nutshell's scope. A validator that only knows part of the course is wrong. Accept lesson entries as either a folder name or `{lesson, blocks}` and normalize before resolving.
- Don't add block types or change block IDs in a rendering PR; that's a content schema change.
- Components in `shared/components/` must be framework islands, not full pages.
- Don't add dependencies without a reason. Prefer what's already in `package.json`.
- Keep the Node version consistent with `.nvmrc`. Don't add syntax that requires a newer version.

## Git and branch rules

- Never commit directly to `main`. Use `content/<topic>` or `feature/<name>` branches and open a PR.
- Never commit `dist/`, `node_modules/`, `.env` files, or the wiki export.
- Keep `package-lock.json` in sync with `package.json`. Commit both together.
- Commit messages: short imperative subject line, for example `Add quiz for detached HEAD`.
- Don't rewrite history on `main`. Force-pushing is only for your own feature branches.

## Wiki

The wiki is generated by `wiki.yml` from text content and pushed to `<repo>.wiki.git`. Don't edit the wiki directly, and don't add wiki-only content. If something should appear in the wiki, add it to the source in `courses/`.

## Deployment

- GitHub Pages deploys from `deploy.yml` on every push to `main`.
- Vercel may also deploy preview URLs for PRs. Keep `npm run build` working on both platforms.
- Only add `vercel.json` for headers or rewrites that are needed. Don't add other platform-specific config without asking.

## Before finishing a task

1. Tests pass (`npm test`).
2. Build passes (`npm run build`).
3. Content validation passes if `courses/` changed, including block syntax, IDs, required blocks, brief references (including per-lesson `blocks` overrides), and media alt text.
4. New engine commands or renderers have tests.
5. The change is on a branch, not `main`.
6. Briefs are compositions only: no copied block text, new objectives, quizzes, or scenarios. Splitting a brief does not duplicate lesson text.
7. Content and rendering changes are in separate PRs.
8. Summarize what changed and what you didn't verify.

## When to ask the maintainer

- Adding a new course, renderer, or output type
- Adding, removing, or renaming a block type
- Changing block syntax, block ID rules, or the brief composition schema
- Promoting a block to a shared, cross-lesson block
- Adding a new brief or changing what the Nutshell includes
- Changing the scenario schema or objective IDs used by existing content
- Adding a backend, accounts, authentication, or any external API
- Changing the deployment setup or branch strategy
- Adding a new runtime dependency that affects the bundle size significantly

Splitting the Nutshell into parts is a composition change, not a schema change. Propose it in a content PR; it needs review, not a new schema decision.
