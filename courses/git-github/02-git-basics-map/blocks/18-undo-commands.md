---
type: Commands
title: Choosing an undo command
---

| Goal | Command | Effect |
| --- | --- | --- |
| Undo a shared commit | `git revert <commit>` | Add a new commit that reverses the change |
| Discard unstaged edits to a file | `git restore <file>` | Replace the working-tree version with the index version |
| Unstage a file | `git restore --staged <file>` | Remove the change from the index, keep the file |
| Move the branch and keep changes staged | `git reset --soft <commit>` | Move the branch label only |
| Move the branch and unstage changes | `git reset <commit>` | Move the branch and reset the index |
| Move the branch and discard changes | `git reset --hard <commit>` | Move the branch, reset the index, and overwrite the working tree |
| Shelve uncommitted changes | `git stash push -m "message"` | Save changes and clean the working tree |
| Restore the newest stash | `git stash pop` | Apply the stash and remove it from the stack |

`git revert` is the only way here to undo a shared commit without rewriting history. The reset commands rewrite your local branch, and `--hard` also discards uncommitted work.
