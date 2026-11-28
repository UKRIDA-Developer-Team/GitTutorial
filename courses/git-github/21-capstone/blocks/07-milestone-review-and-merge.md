---
type: Commands
title: "Milestone 4: review and merge"
---

| Command | What it does |
| --- | --- |
| `git push -u origin add-vegetarian-filter` | Push the branch and set its upstream |
| `gh pr create --base main --head add-vegetarian-filter --title "..." --body "Closes #42"` | Open the pull request and link the issue |
| `gh pr view --comments` | Read the review conversation |
| `gh pr checks --watch` | Wait for CI to finish |
| `gh pr merge --squash --delete-branch` | Squash the branch into `main` and clean up |
| `git switch main` | Return to the base branch |
| `git pull --ff-only` | Sync local `main` with the merge |

A teammate reviews the pull request. If they request changes, make a new commit on the branch and push again. The pull request updates automatically. Reply to the review, then request another look.

Merge only when the review is approved and the required checks pass. Do not use `--admin` to skip a gate, and do not merge with a failing check because the change looks small.

The squash merge creates one commit on `main`. `--delete-branch` removes the remote branch and deletes the local branch when it can. The work stays on `main`; the branch label was only a pointer.

After the merge, local `main` is still behind. Pull before you tag, or you will tag the wrong commit.
