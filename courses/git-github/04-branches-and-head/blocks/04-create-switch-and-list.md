---
type: Commands
title: Create, switch, and list branches
---

| Command | What it does |
| --- | --- |
| `git branch` | List local branches; the current one is marked with `*` |
| `git branch <name>` | Create a branch at the current commit without switching to it |
| `git switch <name>` | Switch to an existing branch |
| `git switch -c <name>` | Create a branch and switch to it in one step |
| `git branch -a` | List local and remote-tracking branches |
| `git branch -vv` | List branches with their upstream and ahead/behind counts |

`git switch -c` is the usual way to start work. It creates the label at the current commit and moves `HEAD` to it, so the next commit advances the new branch instead of the old one.

Creating a branch writes a reference; it does not copy files or commits. The working tree does not change until you switch to a branch with a different snapshot.
