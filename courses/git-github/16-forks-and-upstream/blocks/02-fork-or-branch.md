---
type: Explain
title: Fork or branch
---

A branch is a ref inside one repository. Everyone with write access pushes branches to the same repository, and a pull request compares two branches there.

A fork is a separate repository under your account or an organization. It starts with the source repository's history, but it has its own branches, issues, and settings. You can push to it without permission from the source. A pull request can then compare a branch in your fork, the head, with a branch in the source repository, the base.

Use a branch when you have write access and the change belongs in the same repository. Use a fork when you do not have write access, when the source is a public project accepting outside contributions, or when you need an independent copy that the source cannot change.

A fork is not a branch and not a clone. The fork lives on the platform. A clone is a local copy of a repository, which may be your fork or the upstream. One fork can have many clones, and one clone can have remotes for both.
