---
type: Example
title: Following HEAD through a graph
---

Suppose the history looks like this, where each arrow points to a parent:

```text
A <- B <- C <- D   main
          ^
          feature
```

`HEAD` points to `feature`, so the current commit is C. The working tree matches C, not D.

Now commit twice on `feature`. Git creates E and F, each with a parent, and moves `feature`:

```text
A <- B <- C <- D   main
           \
            E <- F   feature
```

`main` still points to D. Switching to `main` updates the working tree to D. The commits E and F still exist; they are reachable through `feature`.

If you delete `feature` now, E and F become unreachable. They are not deleted immediately, but no branch names them. `git reflog`, which records where branches and `HEAD` have pointed, can usually find them for a while.

The graph is the history. The labels are movable names attached to it.
