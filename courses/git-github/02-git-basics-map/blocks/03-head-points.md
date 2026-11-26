---
type: Explain
title: HEAD marks your position
---

`HEAD` is Git's name for your current position. Normally `HEAD` points to a branch, and the branch points to a commit. This is an attached `HEAD`. When you switch branches, `HEAD` points to the new branch.

`HEAD` can also point directly to a commit instead of a branch. That is called a detached `HEAD`. You get there with `git switch --detach <commit>` or by checking out a commit hash or tag. It is useful for inspecting an old commit or building from a release. A new commit made there is not attached to a branch unless you create one, so it can become hard to find.

`git status` tells you which state you are in. On a branch, it prints `On branch main`. Detached, it prints `HEAD detached at a1b2c3d`.

`HEAD` is also what many commands mean by "the current commit" or "the current branch." `git log` starts from `HEAD`, and `git commit` moves the branch that `HEAD` points to.
