---
type: Commands
title: Reset modes
---

| Command | Branch label | Index | Working tree |
| --- | --- | --- | --- |
| `git reset --soft <commit>` | Moves | Keeps | Keeps |
| `git reset <commit>` | Moves | Resets | Keeps |
| `git reset --hard <commit>` | Moves | Resets | Overwrites |

`git reset` moves the current branch label to the named commit. It does not create a commit, and it does not touch other branches.

The mode decides what happens to the index and working tree:

- `--soft` leaves both alone. The changes between the old and new commit appear as staged changes, ready to recommit differently.
- The default, `--mixed`, resets the index but leaves the working tree. The changes appear as unstaged edits.
- `--hard` resets both. Tracked files in the working tree are overwritten to match the target commit, and uncommitted changes to those files are lost.

Use reset on local history you have not shared. If you only want to unstage a file, `git restore --staged <file>` is clearer and does not move the branch.
