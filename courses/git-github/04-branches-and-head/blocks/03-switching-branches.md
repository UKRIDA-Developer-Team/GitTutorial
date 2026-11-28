---
type: Diagram
title: Switching branches updates the working tree
---

![Before switching, HEAD points to feature and the working tree matches the feature commit. After git switch main, HEAD points to main and the working tree matches the main commit. Both branch labels still point to their commits.](../media/blocks/switching-branches/switching-branches.svg)

The commits stay in place. `HEAD` moves to the target branch, and Git checks out that branch's snapshot into the working tree.
