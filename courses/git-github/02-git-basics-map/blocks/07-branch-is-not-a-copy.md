---
type: Warning
title: A branch is not a copy
---

Creating a branch does not copy your files or duplicate your commits. It adds a label that points at an existing commit. The cost is measured in bytes, not in the size of the project.

The files in your working tree do not change when you create a branch. They change when you switch to a branch whose commit has different contents.

Deleting a branch is also cheap, but it is not a way to delete history. The commits remain reachable through other branches, tags, or the reflog, the local record of where branches and `HEAD` have pointed. They disappear only when nothing references them and garbage collection runs.
