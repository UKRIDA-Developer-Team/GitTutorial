---
type: Diagram
title: Choosing an undo
---

![A decision map. For a shared commit, git revert adds a correcting commit. For a local commit, git reset moves the branch. For a file or the index, git restore changes a file. For a lost commit, git reflog finds the hash.](../media/blocks/undo-decision-map/undo-decision-map.svg)

Shared history is the dividing line: revert adds a commit, while reset rewrites a local branch.
