---
type: Question
title: What happens after the merge?
---

You merge a pull request with `gh pr merge --squash --delete-branch`. What happens to the branch and to your local repository?

GitHub merges the pull request into the base branch and marks it merged. `--delete-branch` removes the remote head branch and deletes the local branch when it can. The pull request and its discussion remain on the platform.

Your local base branch does not move automatically. Switch to it and pull:

```bash
git switch main
git pull --ff-only
```

Because the merge was a squash, `main` receives one new commit containing the branch's combined changes. The branch's individual commits are not on `main`. If you had merged with a merge commit, `main` would contain a merge commit with the branch as its second parent.

The work is preserved either way. What changes is the shape of the history on the base branch.
