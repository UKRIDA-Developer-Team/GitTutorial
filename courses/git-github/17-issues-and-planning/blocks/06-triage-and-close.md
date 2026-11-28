---
type: Commands
title: Triage and close
---

| Command | What it does |
| --- | --- |
| `gh issue edit 42 --add-label bug` | Add a label |
| `gh issue edit 42 --add-assignee @me` | Assign the issue |
| `gh issue edit 42 --milestone v1.2` | Set the milestone |
| `gh issue close 42 --reason completed` | Close as completed |
| `gh issue close 42 --reason "not planned"` | Close without doing the work |
| `gh issue close 42 --duplicate-of 7` | Close as a duplicate |
| `gh issue reopen 42` | Reopen a closed issue |

Closing with a reason preserves the team's intent. `completed` means the work landed. `not planned` means the team decided not to do it. `duplicate` points at the issue that remains open. A closing comment explains the decision when the reason alone is not enough.

Do not close an issue just because a branch exists or a pull request is open. Close it when the work is merged or the team has decided not to proceed. If a pull request uses a closing keyword, the platform closes the issue when the pull request merges.

Reopening is normal when a fix regresses or a decision changes. Add a comment that says why, rather than reopening silently.
