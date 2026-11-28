---
type: Commands
title: Open a pull request
---

| Command | What it does |
| --- | --- |
| `gh pr create --base main --head feature --title "..." --body "..."` | Open a pull request from `feature` into `main` |
| `gh pr create --draft` | Open the pull request as a draft |
| `gh pr list` | List open pull requests |
| `gh pr view` | Show the pull request for the current branch |
| `gh pr view --web` | Open the pull request in a browser |

`gh` reads the repository from the `origin` remote of the current directory. `--base` is the branch you want to merge into, and `--head` is the branch with your work. If you omit them, `gh` prompts for the missing values or uses the current branch.

A draft pull request is visible but marked not ready for review. It still runs checks and accepts comments, which makes it useful for early feedback. Mark it ready when the work is complete enough to review.

If you omit `--body`, `gh` asks for the description interactively. A useful description says what changed, why, and how to test it.
