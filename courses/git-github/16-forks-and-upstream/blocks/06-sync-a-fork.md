---
type: Commands
title: Sync a fork
---

| Command | What it does |
| --- | --- |
| `gh repo sync` | Fast-forward the fork's default branch from its parent |
| `gh repo sync --branch main` | Sync a specific branch |
| `gh repo sync --source OWNER/REPO` | Sync from a source other than the parent |
| `gh repo sync --force` | Hard reset the fork branch to the source |
| `git fetch upstream` | Update the local `upstream/*` refs |
| `git switch main` | Switch to your local default branch |
| `git pull --ff-only` | Update local `main` from `origin` |
| `git rebase upstream/main` | Replay the current branch onto the latest upstream |

`gh repo sync` changes the fork on GitHub, not your local clone. Run it, then switch to your local default branch and pull from `origin` to bring the clone up to date. If the local branch has diverged, the pull fails instead of creating a merge you did not ask for.

`--force` makes the fork branch match the source exactly. It discards commits on the fork branch that are not in the source. Do not use it on a branch that contains work you need, including the head branch of an open pull request.

For a feature branch, fetch upstream and integrate it deliberately. Rebase if the branch is yours and unpublished; merge if it is shared. Then push the updated branch to your fork so the pull request sees the new commits.
