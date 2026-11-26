---
type: Explain
title: Fetch is not pull
---

`git fetch` and `git pull` are easy to confuse because both contact the remote.

`git fetch` only downloads. It updates your remote-tracking branches, such as `origin/main`, and leaves your local branches and working tree untouched. After a fetch, you can inspect what arrived with `git log HEAD..origin/main`, which lists the commits on `origin/main` that are not in `HEAD`, or with `git diff HEAD origin/main`, then decide how to integrate it.

`git pull` is fetch plus integration. By default it merges the remote branch into your current branch; with `pull.rebase` set, it rebases instead. That means a pull can create a merge commit, start a conflict, or rewrite your local commits, depending on configuration and history.

Fetch is the safer habit when you want to look before you leap. Pull is convenient when you already know you want the remote changes. Neither is a backup: fetching does not copy your work anywhere.
