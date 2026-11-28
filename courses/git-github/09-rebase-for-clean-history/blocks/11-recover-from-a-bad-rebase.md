---
type: Commands
title: Recover from a bad rebase
---

| Command | What it does |
| --- | --- |
| `git rebase --abort` | Stop an in-progress rebase and restore the original branch |
| `git reflog` | Find the pre-rebase tip |
| `git reset --hard ORIG_HEAD` | Move the branch back to the tip before the rebase |
| `git reset --hard HEAD@{n}` | Move the branch to a specific reflog entry |
| `git switch -c rescue <hash>` | Preserve the old tip on a separate branch |

`ORIG_HEAD` is set by rebase, merge, and reset to the previous tip. After a completed rebase, `git reset --hard ORIG_HEAD` is the quickest way back. It rewrites the branch and discards working-tree changes, so commit or stash anything you need first.

`git rebase --abort` only works while the rebase is still in progress. Once it finishes, the branch has already moved; use `ORIG_HEAD` or the reflog.

If you want to keep both the old and new tips, create a branch at the old hash instead of resetting. That preserves the pre-rebase work without moving your current branch.
