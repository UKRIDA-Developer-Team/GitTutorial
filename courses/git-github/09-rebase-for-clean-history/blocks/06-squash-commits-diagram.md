---
type: Diagram
title: Squashing commits creates a new commit
---

![Before squashing, three commits sit in a row. After an interactive rebase with squash, one new commit replaces them, and its hash is different.](../media/blocks/squash-commits-diagram/squash-commits-diagram.svg)

Squashing combines the changes and messages of several commits into one. The old commits stay in the reflog; the new commit has a new hash.
