---
type: Warning
title: A pull request is not a Git object
---

A pull request is metadata on a hosting platform, not part of the repository's history. Cloning the repository does not clone pull requests, comments, reviews, or checks.

- **A pull request is not a backup.** The head branch must be pushed. Commits that exist only on your machine are invisible to GitHub.
- **Closing is not merging.** Closing a pull request without merging changes nothing in Git; the branches stay where they were.
- **Do not do the work directly on `main`.** Create a branch, commit there, and open the pull request from that branch.
- **Do not merge with failing checks** unless the team explicitly allows it. The platform may block it anyway.
- **Do not force-push a reviewed branch without telling reviewers.** It rewrites the commits they commented on and can hide the history they approved.
- **Deleting the branch after merge is cleanup, not data loss.** The merge commit or squashed commit keeps the work on the base branch.

The pull request is a conversation around Git, not a replacement for it. The repository still records the commits; the platform records the review.
