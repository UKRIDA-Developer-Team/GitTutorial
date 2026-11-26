---
type: Warning
title: Staging is not committing
---

`git add` puts a version into the index. It does not create a commit. Only `git commit` records the index as a new snapshot in the repository.

If you stage a file, edit it again, and commit without staging again, the commit contains the earlier staged version. Check `git status` before committing when you are unsure.

The reverse mistake also happens: assuming that `git commit` includes everything in the working tree. It does not. Untracked files and unstaged edits stay out until you add them.
