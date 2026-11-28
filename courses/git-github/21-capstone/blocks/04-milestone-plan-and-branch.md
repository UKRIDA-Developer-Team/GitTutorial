---
type: Commands
title: "Milestone 1: plan and branch"
---

| Command | What it does |
| --- | --- |
| `git clone https://github.com/team/recipes.git` | Clone the practice repository |
| `cd recipes` | Enter the repository |
| `git config user.name "Ada Lovelace"` | Set the commit name for this repository |
| `git config user.email "ada@example.com"` | Set the commit email for this repository |
| `git switch main` | Start from the default branch |
| `git pull --ff-only` | Make sure `main` is current |
| `gh issue create --title "..." --body "..."` | Open the feature request |
| `gh issue develop 42 --name add-vegetarian-filter --base main --checkout` | Create and check out the linked branch |

Write the issue with the acceptance criteria from the project brief. The issue is the definition of done, not a place to paste the whole implementation.

`gh issue develop` creates the branch from `main` and links it to the issue. If you prefer to create the branch manually, `git switch -c add-vegetarian-filter` works, but then the issue link comes from the pull request body instead.

Confirm the starting point:

```bash
git status
git log -1 --oneline
```

`git status` should be clean. The latest commit should be the one you pulled from `main`. Do not start the feature on top of uncommitted work from another task.
