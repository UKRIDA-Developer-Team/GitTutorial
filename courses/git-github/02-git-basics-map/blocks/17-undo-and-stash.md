---
type: Explain
title: Undo and stash
---

Git has several ways to undo work, and the correct one depends on what you want to change.

- `git revert` creates a new commit that reverses an earlier commit. It is safe for history that other people already have because it does not rewrite anything. Use it to undo a change that is already shared.
- `git reset` moves the current branch to another commit. `--soft` keeps the index and working tree, `--mixed` resets the index, and `--hard` resets both. It rewrites your local branch, so avoid it on shared history.
- `git restore` restores a file or a staged change from another state. `git restore <file>` discards working-tree edits; `git restore --staged <file>` unstages without touching the file.
- `git stash` saves uncommitted changes and returns the working tree to the last commit. `git stash pop` brings the saved changes back, and `git stash list` shows the stack. Stash is useful when you need a clean working tree without making a commit.

The safe default for shared history is revert. Reset and restore are local tools; use them when you understand which area they change. A hard reset discards uncommitted work, and the reflog, the local record of where branches and `HEAD` have pointed, cannot bring that work back.
