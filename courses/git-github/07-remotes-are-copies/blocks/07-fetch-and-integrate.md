---
type: Commands
title: Fetch and integrate
---

| Command | What it does |
| --- | --- |
| `git fetch` | Download new commits and update remote-tracking branches |
| `git fetch --prune` | Also remove remote-tracking branches whose remote branch is gone |
| `git pull` | Fetch and integrate into the current branch |
| `git pull --ff-only` | Integrate only if it can fast-forward; otherwise stop |
| `git pull --rebase` | Fetch and rebase local commits onto the remote branch |

`git fetch` is the safe half of synchronization. It downloads commits and moves `origin/main`, but it does not change your local branches or your working tree. After a fetch, you can inspect what arrived with `git log HEAD..origin/main` or `git diff HEAD origin/main`, then decide how to integrate it.

`git pull` is fetch plus integration. By default it merges the remote branch into your current branch; with `pull.rebase` set, it rebases instead. A pull can therefore create a merge commit, start a conflict, or replay your local commits, depending on configuration and history.

`git pull --ff-only` is a useful default when you expect a linear update. It refuses to create a merge commit, so it fails loudly when your branch and the remote have diverged instead of producing a merge you did not ask for.

`git fetch --prune` cleans up remote-tracking branches for branches that were deleted on the remote. Without it, `origin/old-feature` can linger after the remote branch is gone.
