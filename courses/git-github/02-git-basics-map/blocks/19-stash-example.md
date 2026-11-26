---
type: Example
title: Stashing work to switch branches
---

You are editing `app.js` when you need to switch branches to fix an urgent bug. The edit is not ready to commit.

```bash
git stash push -m "wip: greeting"
git switch main
# fix the bug and commit it
git switch feature
git stash pop
```

`git stash push` saves the working-tree and index changes and cleans the tree. `git stash pop` applies the newest stash and removes it from the stack. If the files changed on the other branch, the pop can conflict, just like a merge.

`git stash list` shows what is saved. A stash is local to your repository and is easy to forget, so it is a convenience, not a backup. For work you intend to keep, a commit on a temporary branch is more visible.
