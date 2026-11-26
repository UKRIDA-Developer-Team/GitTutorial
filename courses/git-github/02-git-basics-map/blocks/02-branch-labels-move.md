---
type: Explain
title: Commits move branch labels
---

A branch is not a folder or a copy of the project. It is a movable label that points to one commit. In Git, the label is stored as a reference: a small file under `.git/refs/heads/`, or an entry in a packed refs file that Git maintains for compactness, containing a commit hash.

When you commit while that branch is current, Git creates the new commit and moves the branch label forward to it. The previous commit is still there; the branch simply points to the newer one. This is why committing is cheap and why history is a chain of commits rather than a chain of folders.

Creating a branch adds another label at a commit. Both branches can point to the same commit, and they can later move independently as you commit on each one. Deleting a branch removes the label, not the commits it pointed to. If no other label or reference reaches those commits, they become unreachable and are eventually removed by Git's garbage collection, the cleanup process that deletes unreferenced objects.

The commits themselves do not belong to a branch. A branch is a way to name a line of work, not a container that owns commits.
