---
type: Explain
title: Choose the undo
---

Undo is not one command. Git records history, so "undo" can mean adding a correcting commit, moving a branch label, restoring a file, or finding a commit that no label points to anymore. The right choice depends on what you want to change and who already has the history.

Ask four questions:

- **Is the commit already shared?** Use `git revert`. It adds a new commit that reverses the change, so nobody else's history has to change.
- **Is the commit only local?** Use `git reset`. It moves your branch label to another commit. You choose whether the index and working tree follow.
- **Did you only change a file or the index?** Use `git restore`. It replaces a file from another state or unstages a change without moving history.
- **Did you lose a commit?** Use `git reflog` to find it, then create a branch or reset to it.

`git stash` is a related tool, but it shelves uncommitted work rather than undoing a commit. It is covered with the other history operations.

The dividing line is shared history. Revert adds; reset rewrites. Once a commit is pushed and someone may have pulled it, rewriting is a collaboration problem, not just a local edit.
