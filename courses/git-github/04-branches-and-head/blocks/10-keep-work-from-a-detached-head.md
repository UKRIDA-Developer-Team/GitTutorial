---
type: Question
title: How do you keep a commit from a detached HEAD?
---

You run `git switch --detach HEAD~2`, make a commit, and then run `git switch main`. What happens to the new commit, and how do you keep it?

The commit still exists, but no branch points to it. `main` does not include it, and `git log` on `main` will not show it. It is reachable through the reflog for a while.

Find it with `git reflog`, then create a branch at its hash:

```bash
git reflog
git branch rescue <hash>
```

If you are still detached when you notice, `git switch -c rescue` creates the branch at the current commit in one step. Do that before switching away; it is simpler than recovering afterward.
