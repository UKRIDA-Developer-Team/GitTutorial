---
type: Example
title: Rebuilding a version from deltas
---

Suppose a project has 200 versions and five files. Between version 1 and version 200, one file changes in each version.

In a delta-based system, reading version 200 means starting from version 1 and applying 199 changes. If one delta is missing or corrupt, the later versions may be unreadable. The storage is small, but access depends on the whole chain.

In Git, version 200 is a snapshot that points to the current content of each file. Reading it does not require replaying versions 2 through 199. Git may need to decompress or reconstruct objects, but it does not replay the edit history. To see what changed, Git compares snapshot 200 with snapshot 199 and calculates the diff on demand.

The same idea applies when you move between versions. Git updates the working tree to the target snapshot instead of replaying a series of changes.

The tradeoff is real but small. Snapshots can use more space than a tight chain of deltas, which is why Git deduplicates and packs objects. In exchange, every commit is directly readable, and history operations do not depend on a fragile chain.
