---
type: Warning
title: Stale forks
---

A fork is a copy, and copies age. The upstream repository keeps moving while your fork stays where it was. A pull request opened from an old fork can be far behind the base branch, which makes conflicts more likely and review harder.

- Sync the default branch before starting new work. Do not branch from a fork's `main` that has not been updated in months.
- Do not develop on the fork's default branch. Create a feature branch so syncing `main` never disturbs your work.
- `gh repo sync --force` rewrites the fork branch. If that branch is the head of an open pull request, reviewers may lose the commits they reviewed.
- A fork does not inherit Actions secrets, repository secrets, or team permissions. A workflow that passes upstream can fail in the fork for reasons unrelated to the code.
- If the upstream repository is deleted or made private, the fork can become detached from its parent. Keep a local clone of anything you need.

The safe habit is simple: sync, branch, commit, push, open the pull request. Repeat the sync before each new contribution rather than reusing an old branch.
