---
type: Explain
title: Origin and upstream
---

A clone made by `gh repo fork --clone` has two remotes. `origin` is your fork, where you have write access. `upstream` is the source repository, where you may have no write access at all.

The names are conventions, not Git features. You can call the remotes anything. The important part is which URL each name points at. `git remote -v` shows the fetch and push URLs, and `git branch -vv` shows which remote branch a local branch tracks.

Fetching `upstream` updates remote-tracking refs such as `upstream/main`. It does not change your local `main` or your working tree. Those refs are read-only records of what the source repository contained at the last fetch.

If you cloned your fork directly, add the source repository yourself:

```bash
git remote add upstream https://github.com/team/recipes.git
git fetch upstream
```

Push branches to `origin`. A push to `upstream` succeeds only if your account has write access there. For an outside contributor, the pull request from the fork is the way to propose a change to upstream.
