---
type: Explain
title: Switching changes the working tree
---

Switching to a branch moves `HEAD` to that branch and updates the index and working tree to match the branch's commit. The commits themselves do not move. If `main` points to one snapshot and `feature` points to another, switching changes which snapshot you see on disk.

Git carries uncommitted changes across a switch when it can. If a local edit would be overwritten by the target branch's version of the same file, Git refuses the switch and leaves you where you were. That refusal is a safety check, not an error to work around. Commit the work, stash it, or discard it before switching.

`git switch` is the modern command for changing branches. `git checkout` still works and can also check out commits and files, which is why its behavior is easy to confuse. Prefer `git switch` for branches and `git restore` for files.

Switching also updates the index. A staged change that does not conflict with the target branch can remain staged after the switch, which can be surprising. Check `git status` after switching when you have work in progress.
