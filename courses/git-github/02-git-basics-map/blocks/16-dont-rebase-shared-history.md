---
type: Warning
title: Do not rebase shared history
---

Rebase rewrites commits. If you rebase a branch that other people have pulled, their history and yours diverge. They will see duplicate commits, and merging the two versions can reintroduce changes you thought you had removed.

Treat a branch as shared once it has been pushed and someone else may have based work on it. Rebase your own unpublished branches freely; merge shared ones. If you must rewrite a shared branch, coordinate with everyone who uses it first.

A force-push is often how rewritten history reaches the remote. It replaces the remote branch instead of adding to it, so anyone who based work on the old commits has to recover manually.
