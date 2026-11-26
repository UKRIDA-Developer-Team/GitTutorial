---
type: Explain
title: Merge and rebase combine histories
---

Merge joins two histories. It creates a merge commit with two parents: one from your branch and one from the branch being merged in. The existing commits keep their identities, so merge preserves the exact history of both lines of work.

If the branch you are merging into has not moved since the other branch split from it, Git can fast-forward instead: it moves that branch label forward to the other branch's commit without creating a merge commit. The result is a straight line, but no record that a branch existed.

Rebase takes the commits from one branch and replays them onto a new base. The replayed commits are new commits with new hashes, even when their changes are the same. Rebase produces a straight line, but it rewrites the branch's history. A conflict can occur at each replayed commit.

A common rule is to merge shared branches and rebase only commits that nobody else is using. Rewriting a branch that others have based work on causes confusion: their copies point to commits that no longer exist in your history, and the next push or pull has to reconcile two versions of the same work.
