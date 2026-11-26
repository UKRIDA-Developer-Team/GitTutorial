---
type: Explain
title: Diff before you commit
---

`git diff` compares the working tree with the index. It shows changes you have not staged. `git diff --staged` compares the index with the last commit. It shows what the next commit will add.

The two commands answer different questions:

- `git diff` — what have I changed since I staged?
- `git diff --staged` — what am I about to commit?
- `git diff HEAD` — what has changed in total since the last commit, staged and unstaged?

On the first commit there is no `HEAD` yet, so `git diff --staged` compares the index with an empty tree. That is why a new file appears as a new file rather than as a modification. `git diff HEAD` needs a commit to compare against, so it fails until the first commit exists.

Reading the diff before committing catches accidental edits, debug prints, and files you did not mean to include. It is a cheaper check than fixing a commit afterward.
