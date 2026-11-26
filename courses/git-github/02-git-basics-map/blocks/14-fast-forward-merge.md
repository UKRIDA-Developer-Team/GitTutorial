---
type: Example
title: A fast-forward merge
---

Suppose `main` points to C2. You create `feature` at C2, commit C3 and C4 on it, and nobody commits on `main` in the meantime:

```text
C1 <- C2   main
        \
         C3 <- C4   feature
```

`main` has not moved, so merging `feature` into `main` does not need to combine two lines of work. Git moves the `main` label forward to C4:

```text
C1 <- C2 <- C3 <- C4   main, feature
```

This is a fast-forward. No merge commit is created, and the history stays linear. It is the cheapest kind of merge, but it also leaves no record that a branch was merged; the commits simply become part of `main`.

If `main` had moved to C5 while `feature` was being built, the labels would have diverged, and the merge would create a merge commit with two parents instead. The `--no-ff` option forces a merge commit even when a fast-forward is possible, which preserves the branch boundary in history.
