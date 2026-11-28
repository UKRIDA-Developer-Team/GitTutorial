---
type: Commands
title: Checks and merge
---

| Command | What it does |
| --- | --- |
| `gh pr checks` | Show the CI checks for the pull request |
| `gh pr checks --watch` | Wait for the checks to finish |
| `gh pr merge --merge` | Merge with a merge commit |
| `gh pr merge --squash` | Squash the branch's commits into one |
| `gh pr merge --rebase` | Rebase the branch's commits onto the base |
| `gh pr merge --delete-branch` | Delete the branch after merging |

Checks are CI jobs attached to the pull request. A red check means a job failed; branch protection can block the merge until it passes. `gh pr checks` shows the state, and `--watch` waits for a running job to finish.

The merge strategy changes the base branch's history. A merge commit preserves the branch and adds a commit with two parents. A squash combines the branch's commits into one new commit on the base, which keeps the base linear but drops the individual commits from that history. A rebase replays the branch's commits onto the base without a merge commit.

The platform performs the merge on the base branch. Your local base branch does not move until you switch to it and pull. `--delete-branch` removes the remote branch and deletes the local branch when it can; the merged commits stay reachable from the base branch.
