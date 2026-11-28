---
type: Commands
title: Rename and delete branches
---

| Command | What it does |
| --- | --- |
| `git branch -m <new-name>` | Rename the current branch |
| `git branch -m <old-name> <new-name>` | Rename another branch |
| `git branch -d <name>` | Delete a branch that is merged into the current branch |
| `git branch -D <name>` | Delete a branch even if it has unmerged commits |

`-d` refuses to delete a branch whose commits are not reachable from the current branch. That protection is deliberate: it stops you from removing the only label on work you have not merged. `-D` overrides the check and deletes the label anyway. The commits are not erased immediately; they remain reachable through the reflog, another branch, or a tag until garbage collection removes them.

You cannot delete the branch you are on. Switch to another branch first, or rename the current one.

Deleting a branch locally does not delete it on a remote. Remote branch deletion is covered with remotes.
