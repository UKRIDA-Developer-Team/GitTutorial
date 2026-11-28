---
type: Explain
title: Projects are a planning layer
---

GitHub Projects is a planning view over issues and pull requests. A project can show items in a table, a board, or a roadmap, with custom fields such as priority, size, or target date. The items still live as issues or pull requests; the project organizes them.

A project belongs to a user, an organization, or a repository. It can contain draft issues that have not been promoted to real issues yet. That makes projects useful for early planning, while issues remain the durable record of work.

The `gh project` commands need the `project` scope:

```bash
gh auth refresh -s project
gh project create --owner @me --title "Recipes roadmap"
gh project list --owner @me
```

Planning is not the same as permission. Adding an issue to a project does not assign it, label it, or give anyone access to the repository. Keep the project fields small enough that people actually maintain them; a board that is never updated is worse than no board.
