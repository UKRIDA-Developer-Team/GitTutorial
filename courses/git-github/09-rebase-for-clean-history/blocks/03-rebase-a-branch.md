---
type: Commands
title: Rebase a branch
---

| Command | What it does |
| --- | --- |
| `git switch feature` | Switch to the branch you want to rebase |
| `git rebase main` | Replay the commits unique to `feature` onto `main` |
| `git rebase --onto main old-base feature` | Replay only the commits after `old-base` onto `main` |
| `git rebase --continue` | Continue after resolving a conflict |
| `git rebase --skip` | Skip the commit that caused the conflict |
| `git rebase --abort` | Stop the rebase and restore the original branch |

You rebase the branch you are on. `git rebase main` finds the common ancestor of `feature` and `main`, takes the commits after that ancestor, and reapplies them on top of `main`. When it finishes, the `feature` label points to the new tip.

`--onto` is for the case where the old base is not the merge base. It takes three pieces: the new base, the old base, and the branch to move. The commits after the old base are replayed onto the new base.

A rebase does not change the branch you rebase onto. `main` stays where it was; only `feature` moves. The old `feature` tip is recorded in `ORIG_HEAD` and the reflog.
