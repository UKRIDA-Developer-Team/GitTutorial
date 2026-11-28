---
type: Example
title: Rebasing a feature branch
---

`main` has moved since `feature` started:

```text
C1 <- C2 <- C5   main
        \
         C3 <- C4   feature
```

Switch to `feature` and rebase onto `main`:

```text
$ git switch feature
$ git rebase main
Successfully rebased and updated refs/heads/feature.
```

The graph is now linear:

```text
C1 <- C2 <- C5 <- C3' <- C4'   main, feature
```

`C3'` and `C4'` contain the same changes as C3 and C4, but they are new commits with new hashes because their parent is now C5. `main` did not move. `feature` points to the new tip.

`git log --oneline --graph --decorate` shows the result. The old commits are still in the reflog, which is why a rebase is recoverable even though it rewrites history.
