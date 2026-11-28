---
type: Explain
title: Conflicts during a rebase
---

A rebase applies commits one at a time, so a conflict can stop it at any commit in the list. Git pauses, marks the conflicted files, and leaves `HEAD` detached at the commit it is rebuilding. The branch label does not move until the rebase finishes.

Resolve the conflict the same way as a merge: edit the file, remove the markers, stage the resolved file, and run `git rebase --continue`. To drop the commit that caused the conflict, run `git rebase --skip`. To stop and return to the original branch, run `git rebase --abort`.

The sides are labeled differently from a merge. During a rebase, "ours" is the new base you are rebasing onto, and "theirs" is the commit being replayed. That is the reverse of a merge, where "ours" is your current branch. Read the marker lines and `git status` instead of assuming.

A rebase can stop more than once. Each stop is a chance to resolve one commit's conflict; `--continue` moves to the next commit in the list.
