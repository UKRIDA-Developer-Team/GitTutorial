---
type: Commands
title: Review and update a pull request
---

| Command | What it does |
| --- | --- |
| `gh pr checkout <number>` | Check out the pull request's branch locally |
| `gh pr view --comments` | Read the pull request conversation |
| `gh pr review --approve` | Approve the pull request |
| `gh pr review --request-changes --body "..."` | Request changes |
| `gh pr review --comment --body "..."` | Leave a review comment |
| `git push` | Update the pull request with new commits |

As the author, you respond to review by changing the branch and pushing. The pull request updates automatically because it tracks the head branch. Reply to comments on the platform, and re-request review when the update is ready.

As a reviewer, `gh pr checkout <number>` fetches the branch and switches to it, so you can run the code locally. `gh pr view --comments` shows the discussion without leaving the terminal. The review commands record an approval, a change request, or a comment on the platform.

GitHub does not let you approve your own pull request. The review commands are for reviewing someone else's work; the author's job is to push updates and answer comments. Resolving a conversation is a platform action, not a code change.
