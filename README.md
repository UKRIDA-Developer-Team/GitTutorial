# Git Tutorial 

An interactive, multi-format learning platform for Git, GitHub, and shell usage. Each concept is written once and presented in several ways: text, visual diagrams, quizzes, flashcards, video or audio, and a browser-based Git sandbox where learners practice commands and reach goal states.

Lessons are built from reusable content blocks, so the same teaching material can become a full lesson, a brief, or another format without being rewritten.

## Purpose

Most tutorials teach through one medium, usually text with a code block. Learners remember things differently, though, so this project aims to:

- Teach the same concept through multiple output types (text, visual, quiz, game, audio/video), all generated from one source.
- Make learning active. The Git sandbox, target-graph challenges, broken-repo repairs, and merge conflict puzzles require hands-on practice.
- Keep content maintainable. Concepts are defined once, so a fix to a lesson propagates to every format.

## Courses

| Course | Status | Description |
| --- | --- | --- |
| `git-github` | In progress | Git fundamentals and GitHub workflows, taught through the sandbox |
| `unix-shell` | Planned | Using the Unix shell (Bash, Zsh) |
| `windows-shell` | Planned | Using PowerShell and Windows command line |

Shell courses are separate from the Git course. Cross-course links point to each other where concepts overlap, such as `git add` working the same way in Bash and PowerShell.

### Git course sequence

| # | Lesson |
| --- | --- |
| 00 | Version Control and the Git Model |
| 01 | Git Basics: Commits and Areas |
| 02 | Git Basics: The Wider Map |
| 03 | Your First Commit |
| 04 | Branches and HEAD |
| 05 | Merging and Conflicts |
| 06 | Undo and Recovery |
| 07 | Remotes are Copies |
| 08 | Pull Requests |
| 09 | Rebase for Clean History |
| 10–14 | Under the hood |
| 15 | Authentication and Identity |
| 16 | Forks and Upstream |
| 17 | Issues and Planning |
| 18 | Review and Merge at Scale |
| 19 | Actions and CI |
| 20 | Releases, Tags, and Security |
| 21 | Capstone |

The capstone format is not defined yet. It is exempt from the core lesson block minimum until its format is decided.

### Briefs

A brief is a composition of typed content blocks, not a separate course. It contains no new lessons, objectives, quizzes, or scenarios. Assessments are separate artifacts; a quiz or scenario may point to a lesson, and a lesson never depends on one.

A course may have any number of briefs. A brief may cover the whole course, a subset of it, or a split part such as essentials and team workflows. Briefs are independent: the site decides whether to present one, several, or a chooser. The content does not encode that choice.

| Brief | Course | Status | Description |
| --- | --- | --- | --- |
| `nutshell` | `git-github` | Planned | The practical path: lessons 00–09 and 15–20 in one brief |

The Nutshell is the first brief. It is built from the same source as the full course, so a fix to a lesson propagates to the brief. Splitting it later into parts such as `nutshell-essentials` and `nutshell-team` is a composition change, not a schema change, and the combined brief can coexist with those parts.

## Output types (renderers)

| Renderer | Purpose |
| --- | --- |
| `text` | Written lessons and reference pages |
| `visual` | Diagrams and commit graphs generated from lesson data |
| `quiz` | Multiple choice and short-answer questions with feedback |
| `flashcards` | Command and concept recall |
| `game` | Git sandbox challenges: target graphs, broken repo repairs, conflict puzzles, PR simulations |
| `video-audio` | Embedded video and audio with synced scripts |
| `wiki` | Exports text content to the repository's GitHub Wiki |
| `brief` | Planned. Presents a composition of content blocks as simple teaching material |

Briefs are content compositions, not renderers. The `brief` renderer is a separate, later workstream; until it exists, a brief is authored and validated as content only.

## Content blocks

Lessons are composed of typed, self-contained blocks. A block is the smallest reusable teaching unit: one idea, one diagram, one command table, or one warning. Lessons render all of their blocks; briefs compose a subset.

Each lesson keeps its blocks in separate files:

```text
00-version-control-basics/
├── lesson.yaml
├── objectives.yaml
├── intro.md
├── blocks/
│   ├── 01-version-control-is-recorded-history.md
│   ├── 02-a-project-without-history.md
│   └── 03-history-of-version-control.md
└── media/
    └── blocks/
        └── history-timeline/
```

`lesson.yaml` owns the lesson title and block order:

```yaml
title: Version Control and the Git Model
blocks:
  - version-control-is-recorded-history
  - a-project-without-history
  - history-of-version-control
```

A block file contains YAML frontmatter and Markdown content:

```md
---
type: Explain
title: Snapshots, not deltas
---

Older version control systems often stored a file's first version and then a
chain of changes, called deltas. A Git commit records a snapshot of the whole
project.
```

- The filename has a two-digit ordering prefix and the block ID: `07-snapshots-not-deltas.md`.
- The block ID is the filename without the prefix: `snapshots-not-deltas`.
- `lesson.yaml` is the authoritative order. The prefix keeps the directory readable at a glance.
- `type` must be one of the approved block types.
- `title` is the readable heading. It must not contain a type prefix or block ID. It may be omitted when the body is a single statement, as with `Idea` and `Recap`; the renderer then shows the body without a heading.
- The block body is ordinary Markdown. Do not repeat the title as a heading.
- `intro.md` holds lesson-level prose, such as setup notes, that is not a reusable block.

A block ID is lowercase kebab-case, descriptive, and unique within its lesson (for example, `branch-is-a-label`, not `b1`). Reference a block as `<lesson-folder>#<block-id>`, for example `04-branches-and-head#branch-is-a-label`. Block IDs are stable: changing the numeric prefix is not an ID change; renaming the descriptive part is.

Approved block types:

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

A `Question` block is teaching content. It poses a concrete situation and answers it in the same block. It is not a quiz: it has no hidden answer, scoring, or objective.

Blocks are content, not lessons. They have no completion state, prerequisites, objectives, quizzes, or scenarios. A block must make sense on its own, without "as we saw above" or other context from the surrounding lesson.

A lesson may assume earlier lessons in the same course. The full explanation of a concept belongs to the lesson that introduces it. Later lessons may restate it in a one-line `Recap`, then apply it with commands or examples. They do not copy the full block or create a second definition.

Assessments are separate artifacts. A lesson exists without a quiz. A quiz may point to a lesson and use that lesson's objectives, or stand alone and define its own. A lesson never links to a quiz.

### Brief composition

A brief is a composition of blocks. It is not a course and does not define objectives, quizzes, scenarios, or progress. Its intro and outro may orient and summarize, but they must not introduce new concepts.

Brief files live under `courses/<course>/briefs/<name>/`:

```
briefs/
  nutshell/
    brief.yaml
    intro.md
    outro.md
```

`brief.yaml` lists the source lessons and the block types to include. Block order follows lesson order; the type list is a filter.

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

`lessons` may list any subset of the course's lessons. The `blocks` list is a filter. A lesson entry may be a folder name or an object that narrows the block types for that lesson:

```yaml
include:
  lessons:
    - 01-git-basics-commits
    - lesson: 16-forks-and-upstream
      blocks: [idea, explain, warning]
  blocks: [idea, explain, diagram, commands, warning, question]
```

A lesson entry without its own `blocks` inherits the brief-level filter. This keeps a brief short without changing the block schema.

A course may have one brief, several focused briefs, or a combined brief plus split parts. Splitting or combining briefs changes only the manifests; the blocks stay canonical. `include.briefs` (a brief composed from other briefs), `exclude`, and ordering metadata are possible later extensions, not part of the schema yet.

Content comes first. Brief rendering is a separate workstream and must not block content authoring. Future layouts may include a page, slide deck, script or storyboard, and illustration; those are rendering decisions, not content requirements.

### Block guardrails

- Compose, don't copy. One canonical block; lessons and briefs reference it.
- Keep blocks self-contained and focused on one idea.
- Use stable IDs, approved types, and the block-file layout.
- Core lessons stand alone from the brief, not from the course sequence. A learner must never need the brief to understand a lesson; a lesson may assume earlier lessons.
- Teach a concept once, in the lesson that introduces it. Later lessons may recap it in one line, then apply it.
- Briefs add no new teaching content or assessments.
- Quizzes, flashcards, and scenarios are separate from lessons and blocks. A lesson never depends on an assessment.
- Briefs may be split or combined; composition lives in `brief.yaml`, never in lesson text.
- Don't put layout language in content.
- Put per-block media in `media/blocks/<block-id>/`; link it from the block file with a path relative to that file.
- Don't block-ify prose that only works in one lesson.
- If two lessons need the same block, promote it to a shared block instead of copying it.
- Validate block files, IDs, prefix order, required blocks, and media before merging.

See `AGENTS.md` for the full rules.

## Architecture

Content is the source of truth, and renderers turn it into output.

```
courses/   content: lessons composed of typed blocks, briefs, objectives, quizzes, scenarios
shared/    code: renderers and reusable UI components (consume resolved block data)
site/      Astro project: layout, navigation, pages, theme, build config
dist/      generated static site (not committed)
```

- **Blocks** are the smallest reusable teaching unit. Lessons render all of them; briefs compose a subset.
- **Briefs** are compositions of blocks, not courses. They contain no new objectives, quizzes, or scenarios.
- **Renderers** answer "how do I show this kind of content?" They have no knowledge of the site layout.
- **Site** answers "how is everything assembled and served?" It loads courses and renderers into pages.
- **Sandbox engine** is a custom simulated Git implementation in `shared/`. It supports only the commands the courses teach, and it grades by comparing repository state to a goal, not by matching command sequences.

### Scenario example

Each game challenge is a YAML file with a starting state, a goal state, allowed commands, and hints:

```yaml
id: git-02-fix-detached-head
title: "Oops, I'm in detached HEAD"
objective: git.branching.recover-detached
start:
  commits:
    - { id: a1, parent: null, message: "init" }
    - { id: b2, parent: a1, message: "add login" }
  branches: { main: b2 }
  head: { detached: b2 }
goal:
  branches: { main: b2, feature: b2 }
  head: { branch: feature }
allowed_commands: [git switch, git checkout, git branch, git log]
hints:
  - "You're not on any branch. Create one here."
  - "Try `git switch -c <name>`."
xp: 20
```

A quiz may point to a lesson and use that lesson's `objective` IDs, or stand alone with its own. Scenarios and flashcards also reference objectives, so one concept can be practiced in several formats without making the lesson depend on an assessment.

## Tech stack

- **Astro** for the static site, with interactive components (React or Svelte) as islands. Most pages ship no JavaScript.
- **xterm.js** for the sandbox terminal.
- **Node.js** for the build toolchain, pinned in `.nvmrc`.
- **Vitest** for engine and content tests.
- **GitHub Actions** for CI, deployment, and wiki export.

## Getting started

Requirements: Node.js (version in `.nvmrc`) and npm.

```bash
git clone https://github.com/<your-username>/GitTutorial.git
cd GitTutorial
npm install
npm run dev       # local dev server
npm test          # engine and content tests
npm run build     # produces dist/
```

## Deployment

The build (`npm run build`) is the same everywhere. Deploy targets are thin layers on top of it:

- **GitHub Pages:** a workflow builds and deploys `dist/` on every push to `main`.
- **Vercel:** optional. Connected to the same repo, it provides preview URLs for each PR and can set custom headers via `vercel.json`.

## Wiki

Text content is exported to the repository's GitHub Wiki by `wiki.yml`. The wiki is a separate repository (`<repo>.wiki.git`). Its pages are generated, so edit the source in `courses/`, not the wiki directly.

## Contributing

1. Create a branch: `content/<topic>` for lessons, `feature/<name>` for code.
2. Make changes and run `npm test` and `npm run build` locally.
3. Open a pull request to `main`. CI runs tests and content validation.
4. Merge after review. Pushes to `main` deploy automatically.

Keep content and rendering changes in separate PRs. Content follows the block rules in `AGENTS.md`; a brief is composed from blocks, not copied from lessons.

Tags such as `v0.1.0` mark course releases.

## Project layout

```
GitTutorial/
├── courses/
│   ├── git-github/
│   │   ├── 00-version-control-basics/
│   │   │   ├── lesson.yaml        # title and block order
│   │   │   ├── objectives.yaml
│   │   │   ├── intro.md
│   │   │   ├── blocks/
│   │   │   │   ├── 01-version-control-is-recorded-history.md
│   │   │   │   └── 08-delta-vs-snapshot.md
│   │   │   └── media/
│   │   │       └── blocks/
│   │   │           └── delta-vs-snapshot/
│   │   ├── 01-git-basics-commits/
│   │   ├── 02-git-basics-map/
│   │   ├── 03-first-commit/
│   │   └── briefs/                  # one folder per brief; more may be added
│   │       └── nutshell/
│   │           ├── brief.yaml
│   │           ├── intro.md
│   │           └── outro.md
│   ├── unix-shell/
│   └── windows-shell/
├── shared/
│   ├── renderers/
│   └── components/
├── site/
├── scripts/
├── tests/
├── .github/workflows/
│   ├── ci.yml
│   ├── deploy.yml
│   └── wiki.yml
├── .nvmrc
├── package.json
├── package-lock.json
├── vercel.json
└── README.md
```

## License

TBD.
