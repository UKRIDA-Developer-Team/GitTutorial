---
type: Example
title: Fast-forward or true merge
---

A fast-forward happens when the receiving branch has not moved. Suppose `main` is at C2 and `feature` has two commits on top of it:

```text
C1 <- C2   main
        \
         C3 <- C4   feature
```

Switch to `main` and merge:

```text
$ git switch main
$ git merge feature
Updating 1a2b3c4..5d6e7f8
Fast-forward
 greeting.txt | 1 +
 1 file changed, 1 insertion(+)
```

`main` now points to C4. No merge commit was created, and the history stays linear.

A true merge happens when both branches have moved:

```text
C1 <- C2 <- C5   main
        \
         C3 <- C4   feature
```

```text
$ git merge feature
Merge made by the 'ort' strategy.
 greeting.txt | 1 +
 1 file changed, 1 insertion(+)
```

Git creates a merge commit with two parents: C5 from `main` and C4 from `feature`. The graph now shows both lines joining:

```text
C1 <- C2 <- C5 <- M   main
        \        /
         C3 <- C4   feature
```

`M` is the merge commit. Its first parent is the branch you were on; its second parent is the branch you merged. `git log --oneline --graph --decorate` draws the shape.
