---
type: Commands
title: Stage and commit
---

| Command | What it does |
| --- | --- |
| `git add README.md` | Stage the current version of a file |
| `git add .` | Stage changes under the current folder |
| `git commit -m "Add README"` | Record the staged changes as a commit |
| `git log --oneline` | List commits, one line each |
| `git diff` | Compare the working tree with the index |
| `git diff --staged` | Compare the index with the last commit |

A commit message should say why the change exists. A short imperative subject such as `Add README` or `Fix login redirect` is easier to scan than `changed stuff`. Staging copies a chosen version into the index; committing records the index as a new snapshot.

`git commit` without `-m` opens your configured editor so you can write a longer message. The first line becomes the subject, and the rest becomes the body.
