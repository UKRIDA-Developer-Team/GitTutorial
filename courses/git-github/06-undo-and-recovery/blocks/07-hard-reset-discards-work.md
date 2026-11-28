---
type: Warning
title: Hard reset discards work
---

`git reset --hard` overwrites tracked files in the working tree. Uncommitted edits to those files are gone, and the reflog cannot bring them back because they were never committed.

- It does not remove untracked files. Those stay until you delete them or run `git clean`, which is even more destructive.
- It does not recover commits. It moves the branch and rewrites files. The reflog can recover commits, not edits that were never recorded.
- It rewrites the branch. If the branch is shared, a hard reset makes your history diverge from everyone else's.
- It is not the way to unstage. Use `git restore --staged <file>` for that.
- It is not the way to discard one file's edits. Use `git restore <file>` for that.

If you want to keep the changes while moving the branch, use `--soft` or `--mixed`. If you want to undo a shared commit, use `git revert`. Reach for `--hard` only when you are sure the working tree has nothing you need.
