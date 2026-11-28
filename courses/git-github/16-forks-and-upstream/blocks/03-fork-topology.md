---
type: Diagram
title: Fork topology
---

![The upstream repository is copied to a fork under your account. A local clone has origin pointing at the fork and upstream pointing at the source repository. Commits flow from the clone to the fork, and a pull request flows from the fork back to upstream.](../media/blocks/fork-topology/fork-topology.svg)

The clone pushes to `origin`, your fork. The fork's pull request targets `upstream`, the source repository.
