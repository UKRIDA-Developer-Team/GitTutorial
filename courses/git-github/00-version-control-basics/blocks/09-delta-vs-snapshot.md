---
type: Diagram
title: Delta chains and snapshots
---

![A delta-based history stores a base file and a chain of changes. A snapshot history stores each commit as a complete project state and calculates differences between snapshots.](../media/blocks/delta-vs-snapshot/delta-vs-snapshot.svg)

A delta-based history stores changes between versions. A snapshot history stores each version as a complete project state, then computes differences when needed.
