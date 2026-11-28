---
type: Explain
title: What reviewers see
---

A reviewer sees the pull request's diff, its commits, its checks, and the conversation. They can comment on a line, approve the change, or request changes. Those actions are stored on the platform; they are not commits.

Review is about the branch, not a frozen snapshot. When you push another commit, the diff and the commit list update. A comment on a line may become outdated if the line changes, which is why reviewers often re-read the diff after an update.

Small, focused pull requests are easier to review and faster to merge. A pull request that mixes a refactor, a feature, and a formatting pass hides the change that matters. If the work is large, split it into a sequence of pull requests or keep the first one behind a draft until the shape is clear.

The description is part of the review. Say what changed, why, and how to test it. Link the issue it addresses if there is one. A reviewer who has to reconstruct the intent from the diff will be slower and less accurate.
