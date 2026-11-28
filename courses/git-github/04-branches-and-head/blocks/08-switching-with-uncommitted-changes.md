---
type: Warning
title: Switching with uncommitted changes
---

Git tries to carry uncommitted changes across a switch. That is convenient when the changes do not overlap the target branch, and it is a trap when they do.

- If an edit would be overwritten by the target branch's version of the same file, Git refuses the switch and leaves you on the current branch. Read the message; it names the file that is in the way.
- Staged changes can remain staged after a switch. The index is not automatically reset to the target branch.
- Untracked files can block a switch if the target branch tracks a file at the same path. Git will not overwrite an untracked file.
- A switch can leave you with a mixture of two branches in the working tree when the files do not overlap. Check `git status` before you continue.

Commit the work, stash it, or discard it before switching when you are unsure. A clean switch is easier to reason about than a rescued one.
