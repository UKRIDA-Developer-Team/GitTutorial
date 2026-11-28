---
type: Explain
title: Why conflicts happen
---

A merge compares three versions of the project: the common ancestor of the two branches, the current branch, and the branch being merged. The common ancestor is the base. The current branch is "ours". The branch being merged is "theirs".

For each region of each file, Git asks whether only one side changed it. If only one side changed it, Git takes that change. If both sides changed the same region in the same way, the result is unambiguous. If both sides changed the same region differently, Git cannot choose. It stops and marks a conflict.

A conflict is about overlapping edits, not about which branch is newer or which commit came first. Two branches can edit different files, or different parts of the same file, and merge without a conflict. The trouble starts when the changes touch the same lines or adjacent lines that the merge algorithm cannot separate cleanly.

Git writes both versions into the conflicted file and records the unmerged path in the index. The merge is paused, not finished. You decide the final content, stage it, and commit the result.
