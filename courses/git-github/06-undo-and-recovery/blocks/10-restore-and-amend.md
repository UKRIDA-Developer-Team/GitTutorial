---
type: Commands
title: Restore files and amend a commit
---

| Command | What it does |
| --- | --- |
| `git restore <file>` | Replace the working-tree file with the index version |
| `git restore --staged <file>` | Unstage a change, keeping the working-tree version |
| `git restore --source=<commit> <file>` | Restore a file from a specific commit |
| `git commit --amend` | Replace the last commit with a new one |
| `git commit --amend --no-edit` | Amend without changing the message |

`git restore` works on files and the index, not on history. `git restore <file>` discards unstaged edits to that file. `git restore --staged <file>` removes the file from the index but leaves the working-tree content alone, which is the modern way to unstage.

`git commit --amend` replaces the last commit. Stage the missing change first, then amend. The replacement has a new hash because the content changed. Amend only a commit you have not pushed, or one you can safely force-push. Rewriting a pushed commit makes everyone else's copy diverge. Changing an older commit is a rebase task.
