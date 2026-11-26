---
type: Diagram
title: The parts of a commit
---

![A commit object with a tree, a parent commit, author and committer metadata, a message, and a hash. The tree points to the project snapshot; the parent points to the previous commit.](../media/blocks/commit-anatomy/commit-anatomy.svg)

A commit ties a project snapshot to its place in history. The tree holds the snapshot, the parent links it to the previous commit, and the hash identifies the whole object.
