---
type: Warning
title: A clean status is not a backup
---

`nothing to commit, working tree clean` means the working tree matches the index and the last commit. It does not mean your work is saved anywhere else.

A clean repository can still be:

- ahead of its remote, with commits that exist only on your machine;
- on a different branch than you expected;
- missing files that were never tracked;
- full of commits that were never pushed.

`git status` is a local comparison. Check the branch name and, when collaboration matters, whether the branch has an upstream and whether it is ahead or behind. A clean status is a statement about three local areas, not about backups or shared history.
