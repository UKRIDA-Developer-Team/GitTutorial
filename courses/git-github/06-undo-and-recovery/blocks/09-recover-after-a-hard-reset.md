---
type: Example
title: Recovering a commit after a hard reset
---

You commit work, then run `git reset --hard HEAD~1` and watch the commit disappear from `git log`. The commit is still in the reflog.

```text
$ git reflog
a1b2c3d HEAD@{0}: reset: moving to HEAD~1
d4e5f6a HEAD@{1}: commit: Add greeting
```

`d4e5f6a` is the commit you moved away from. You have two ways to keep it.

Create a branch at the commit, leaving your current branch where it is:

```bash
git switch -c rescue d4e5f6a
```

Or move the current branch back to it:

```bash
git reset --hard d4e5f6a
```

The first option is safer when you are unsure. It preserves the commit without changing the branch you were on, and you can merge or inspect it later. The second option restores the branch to the lost commit but discards any working-tree changes made since the reset.

Use the full or abbreviated hash from the reflog. `HEAD@{1}` also works as a name, but it moves as new entries are added, so a hash is clearer in notes and commands.
