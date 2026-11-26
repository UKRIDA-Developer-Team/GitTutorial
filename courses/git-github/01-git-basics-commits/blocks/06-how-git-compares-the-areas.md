---
type: Explain
title: How Git compares the areas
---

Git can compare three snapshots: the working tree, the index, and the last commit. `git status` reports the first two comparisons.

- Between the working tree and the index: changes you have made but not staged. These appear under "Changes not staged for commit."
- Between the index and the last commit: changes you have staged for the next commit. These appear under "Changes to be committed."
- Between the working tree and the last commit: the total change since the last commit. This is what `git diff HEAD` shows.

Because each comparison is separate, the same file can appear in more than one list. A file can be staged with one content and modified again in the working tree, so it differs from the index and from the commit in different ways.

A new repository has no last commit, so the comparison against "the last commit" uses an empty tree. Every staged file appears as a new file.
