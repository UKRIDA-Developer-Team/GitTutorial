---
type: Commands
title: Revert a shared commit
---

| Command | What it does |
| --- | --- |
| `git revert <commit>` | Create a new commit that reverses the named commit |
| `git revert --no-commit <commit>` | Apply the reversal to the index and working tree without committing |
| `git revert -m 1 <merge-commit>` | Revert a merge commit relative to its first parent |
| `git revert --continue` | Continue a revert after resolving a conflict |
| `git revert --abort` | Stop a revert and restore the pre-revert state |

`git revert` does not delete or rewrite the original commit. It reads the change that commit introduced and applies the opposite change as a new commit. That is why it is safe for history other people already have.

A revert can conflict, just like a merge, if later commits changed the same lines. Resolve the conflict, stage the file, and run `git revert --continue`. To back out, `git revert --abort`.

Reverting a merge commit needs `-m` because the commit has two parents. `-m 1` treats the first parent, usually the branch you merged into, as the mainline. Reverting a merge is uncommon; read the history before choosing the parent.
