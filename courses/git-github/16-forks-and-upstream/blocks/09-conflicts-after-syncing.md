---
type: Question
title: Why does the pull request still conflict after a sync?
---

You run `gh repo sync` and the fork's `main` is now current. The open pull request still reports conflicts. Why?

`gh repo sync` updated the fork's default branch. The pull request's head branch is a different branch, and it still starts from the old commit. Syncing `main` does not move the feature branch or merge the new upstream work into it.

Bring upstream into the feature branch explicitly:

```bash
git switch fix-typo
git fetch upstream
git rebase upstream/main
# resolve conflicts, then
git push --force-with-lease origin fix-typo
```

A merge works too:

```bash
git merge upstream/main
```

Rebase keeps the branch linear and rewrites its commits, so use `--force-with-lease` and tell reviewers if they already reviewed it. A merge preserves the existing commits and adds a merge commit.

After the push, the pull request recalculates its diff against the base. If conflicts remain, check that the pull request targets the branch you think it does and that the fork is the head repository.
