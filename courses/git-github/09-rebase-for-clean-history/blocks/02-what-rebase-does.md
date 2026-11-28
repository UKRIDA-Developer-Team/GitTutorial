---
type: Explain
title: What rebase does
---

A merge joins two lines of history and keeps both. A rebase takes the commits that are unique to your branch and reapplies them, one by one, on top of another commit. The result is a straight line: your work appears to have started from the new base.

The commits are new. Each replayed commit gets a new hash because its parent changed, even when its changes are identical. The original commits are not deleted immediately; they remain reachable through the reflog and `ORIG_HEAD` until garbage collection.

Rebase is useful when you want a feature branch to sit cleanly on top of the latest `main` before review, or when you want to tidy local commits before sharing them. It is not a way to combine two histories that both need to remain visible; that is what merge is for.

The tradeoff is rewriting. A rebase changes the branch's history, so anyone who already has the old commits will diverge. Rebase your own unpublished work freely; merge shared work, or coordinate before rewriting it.
