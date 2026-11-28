---
type: Commands
title: Inspect branch state
---

| Command | What it does |
| --- | --- |
| `git branch --merged` | List branches whose commits are already reachable from the current branch |
| `git branch --no-merged` | List branches with commits not yet in the current branch |
| `git branch --contains <commit>` | List branches that contain a given commit |
| `git log --oneline --graph --all --decorate` | Show the commit graph with branch and tag labels |

`git branch --merged` is a safe starting point before deleting branches. A branch listed there has no commits that the current branch lacks, so deleting its label loses nothing. `--no-merged` lists branches with work you would lose from the current line of history.

`--contains` answers the reverse question: which branches include this commit? It is useful after a merge, when you want to know where a change landed.
