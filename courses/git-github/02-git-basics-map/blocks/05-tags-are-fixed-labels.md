---
type: Explain
title: Tags are fixed labels
---

A tag is a label that points to a commit and does not move when new commits are made. Tags are commonly used to mark releases, such as `v1.0.0`.

A lightweight tag is just a name for a commit, stored like a branch label but under `.git/refs/tags/`. An annotated tag is a full object: it stores a message, a tagger, and a date, and it points to the commit. Annotated tags are better for releases because they carry context and can be signed.

Tags are useful because a version number should keep pointing to the exact commit that was released, even after the branch moves on. If `main` continues with new commits, `v1.0.0` still names the release commit. A branch would have moved with the work.

Tags are not branches. You do not commit "on" a tag, and a tag does not advance. To change what a release points to, you delete and recreate the tag, which is a deliberate and visible act.
