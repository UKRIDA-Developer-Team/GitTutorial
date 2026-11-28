---
type: Explain
title: Detached HEAD without fear
---

A detached `HEAD` means `HEAD` points directly to a commit instead of a branch. You get there with `git switch --detach <commit>`, or by checking out a commit hash or tag. `git status` reports `HEAD detached at <hash>`.

In this state you can inspect files, build, test, and even commit. A new commit is created normally, but no branch label moves to it. If you switch away without creating a branch, the commit is reachable only through the reflog, the local record of where `HEAD` and branches have pointed. It is not lost immediately, but it is easy to lose track of.

To keep work made in a detached state, create a branch before switching away:

```bash
git switch -c rescue
```

That creates a label at the current commit and attaches `HEAD` to it. If you already switched away, find the commit with `git reflog` and create a branch at its hash:

```bash
git branch rescue <hash>
```

To leave without keeping anything, switch back to a branch with `git switch main` or `git switch -`.
