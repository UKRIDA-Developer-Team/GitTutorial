---
type: Explain
title: Snapshots, not deltas
---

Older version control systems often stored a file's first version and then a chain of changes, called deltas. To rebuild version 50, the system started at version 1 and applied 49 changes in order. Storage was small, but reading an old version could be slow, and a damaged delta could break every later version.

Git takes a different conceptual approach: each commit records a snapshot of the whole project at that moment. The snapshot is the project state, not a list of lines that changed. If a file did not change between two commits, Git does not need to store another full copy; it reuses the existing content and points both snapshots at it.

This is why the snapshot model is not as wasteful as it sounds. Git stores file contents under a hash of their content, so identical files are stored once. It also compresses objects into packfiles, which are packed bundles of many objects. The result is that a commit behaves like a complete project state while the storage stays compact.

The practical difference is that you do not have to replay a chain of patches to understand what the project looked like at a commit. Git calculates a diff when you ask for one, such as with `git diff` or `git show`.
