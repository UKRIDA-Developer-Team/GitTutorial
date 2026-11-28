---
type: Commands
title: Create and read issues
---

| Command | What it does |
| --- | --- |
| `gh issue create --title "..." --body "..."` | Open an issue |
| `gh issue create --label bug --assignee @me` | Open an issue with metadata |
| `gh issue list` | List open issues |
| `gh issue list --state all --label bug` | List issues by state and label |
| `gh issue view 42` | Show an issue |
| `gh issue view 42 --comments` | Show the issue and its comments |
| `gh issue comment 42 --body "..."` | Add a comment |

Without `--title` or `--body`, `gh issue create` prompts for them. A useful issue states what happened, what was expected, how to reproduce it, and what would count as done. For a feature, it states the problem and the acceptance criteria rather than only the proposed implementation.

`gh issue list` shows open issues by default. Filters such as `--state`, `--label`, `--assignee`, `--milestone`, and `--search` narrow the list. `gh issue view --comments` reads the discussion without opening a browser.

An issue number is stable within its repository. Use it in conversation and in links; do not confuse it with a commit hash or a pull request number, which are different namespaces.
