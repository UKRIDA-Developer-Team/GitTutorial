---
type: Commands
title: Inspect the rules
---

| Command | What it does |
| --- | --- |
| `gh ruleset list` | List rulesets that apply to the repository |
| `gh ruleset view` | Show a ruleset's rules |
| `gh ruleset check main` | Show the rules that apply to `main` |
| `gh pr checks --required` | Show only the required checks |
| `gh pr view --json reviewDecision,mergeStateStatus,mergeable` | Show review and merge state |
| `gh pr merge --auto --squash` | Enable auto-merge when requirements are met |

`gh ruleset check` is the quickest way to see why a branch is protected. It reports rules even when the branch does not exist yet, so you can inspect a naming pattern before creating a branch.

`gh pr view --json` turns the pull request state into fields you can read or script. `reviewDecision` reports whether review is required or approved. `mergeStateStatus` reports whether the pull request is clean, blocked, behind, unstable, or has a conflict. `mergeable` reports whether Git can merge it at all.

`--auto` does not bypass the gates. It waits for them. If the branch requires a merge queue, `gh pr merge` adds the pull request to the queue when required checks have passed; otherwise it enables auto-merge and waits.
