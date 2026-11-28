---
type: Commands
title: Merge a branch
---

| Command | What it does |
| --- | --- |
| `git merge <branch>` | Merge the named branch into the current branch |
| `git merge --no-ff <branch>` | Always create a merge commit, even when a fast-forward is possible |
| `git merge --ff-only <branch>` | Merge only if it can fast-forward; otherwise stop |
| `git log --oneline --graph --decorate` | Show the merged history as a graph |

You merge into the branch you are on. Switch to the receiving branch first, then name the branch to bring in:

```bash
git switch main
git merge feature
```

The current branch receives the merge. The named branch does not change; its commits are now reachable from both labels.

A merge can finish in one of two ways. If the receiving branch has not moved since the other branch split from it, Git can fast-forward: it moves the receiving label to the other branch's commit. If both branches have new commits, Git creates a merge commit with two parents. `--no-ff` forces the second form even when a fast-forward is possible, which keeps a visible record that a branch existed.
