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

### Briefs

A brief is a composition of typed content blocks, not a separate course. It contains no new lessons, objectives, quizzes, or scenarios; it links to the practice in the course it draws from.

| Brief | Course | Status | Description |
| --- | --- | --- | --- |
| `nutshell` | `git-github` | Planned | A short, self-contained teaching material assembled from the core lessons' blocks |

The Nutshell is the first brief. It is built from the same source as the full course, so a fix to a lesson propagates to the brief.

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

Lessons are composed of typed, self-contained blocks. A block is the smallest reusable teaching unit: one idea, one diagram, one command table, or one warning. Lessons render every block; briefs compose a subset.

Blocks use a level-2 Markdown heading with a type prefix and a stable ID:

```md
## Idea: A branch is a label {#branch-is-a-label}

A branch is a name that points at a commit.

## Commands {#branch-commands}

| Command | What it does |
| --- | --- |
| `git branch feature` | Create a label at the current commit |
| `git switch feature` | Move HEAD and update the working tree |

## Warning: HEAD can detach {#branch-warning}

`HEAD` can point directly at a commit. Create a branch before committing.
```

The type is the heading prefix before the colon, or the whole heading when there is no colon; the ID is the `{#...}` value.

Approved block types:

| Type | Purpose | Required in core lessons |
| --- | --- | --- |
| `Idea` | One-sentence takeaway | Yes |
| `Explain` | Short explanation | Optional |
| `Diagram` | Visual model with alt text | When a visual helps |
| `Commands` | Command table | When the lesson teaches commands |
| `Example` | Concrete walkthrough | Optional |
| `Warning` | Common mistake | Yes |
| `Practice` | Links to the lesson's quiz or scenario | Yes |
| `Recap` | One-line checklist item | Optional |

A block ID is lowercase kebab-case, descriptive, and unique within its lesson (for example, `branch-is-a-label`, not `b1`). Reference a block as `<lesson-folder>#<block-id>`, for example `03-branches-and-head#branch-is-a-label`. Block IDs are stable: renaming one requires updating every reference.

Blocks are content, not lessons. They have no completion state, prerequisites, objectives, quizzes, or scenarios. A block must make sense on its own, without "as we saw above" or other context from the surrounding lesson.

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
    - 01-version-control-basics
    # ... through 08-rebase-for-clean-history
  blocks: [idea, diagram, commands, warning]

intro: intro.md
outro: outro.md
```

If a lesson has multiple blocks of the same type and the brief needs only one, list explicit block IDs instead.

Content comes first. Brief rendering is a separate workstream and must not block content authoring. Future layouts may include a page, slide deck, script or storyboard, and illustration; those are rendering decisions, not content requirements.

### Block guardrails

- Compose, don't copy. One canonical block; lessons and briefs reference it.
- Keep blocks self-contained and focused on one idea.
- Use stable IDs and the approved block types.
- Core lessons must stand alone without the brief.
- Briefs add no new teaching content or assessments.
- Don't put layout language in content.
- Put per-block media in `media/blocks/<block-id>/` and include alt text.
- Don't block-ify prose that only works in one lesson.
- If two lessons need the same block, promote it to a shared block instead of copying it.
- Validate block IDs, references, required blocks, and media before merging.

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

Quizzes and flashcards reference the same `objective`, so one concept is practiced in several formats.

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
│   │   ├── 01-version-control-basics/
│   │   │   ├── lesson.md          # typed blocks
│   │   │   ├── objectives.yaml
│   │   │   ├── quiz.yaml
│   │   │   ├── scenario.yaml
│   │   │   ├── script.md
│   │   │   └── media/
│   │   │       └── blocks/
│   │   │           └── snapshots-not-copies/
│   │   └── briefs/
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
