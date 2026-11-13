# Git Tutorial 

An interactive, multi-format learning platform for Git, GitHub, and shell usage. Each concept is written once and presented in several ways: text, visual diagrams, quizzes, flashcards, video or audio, and a browser-based Git sandbox where learners practice commands and reach goal states.

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

## Architecture

Content is the source of truth, and renderers turn it into output.

```
courses/   content: lessons (Markdown), objectives, quizzes, scenarios (YAML)
shared/    code: renderers and reusable UI components
site/      Astro project: layout, navigation, pages, theme, build config
dist/      generated static site (not committed)
```

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

Tags such as `v0.1.0` mark course releases.

## Project layout

```
GitTutorial/
├── courses/
│   ├── git-github/
│   │   └── 01-version-control-basics/
│   │       ├── lesson.md
│   │       ├── objectives.yaml
│   │       ├── quiz.yaml
│   │       ├── scenario.yaml
│   │       ├── script.md
│   │       └── media/
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
