---
type: Example
title: Unblock a pull request
---

A pull request is open and its checks are green, but it cannot merge. Inspect the state:

```text
$ gh pr view 128 --json reviewDecision,mergeStateStatus,mergeable
{
  "mergeable": "MERGEABLE",
  "mergeStateStatus": "BLOCKED",
  "reviewDecision": "REVIEW_REQUIRED"
}
```

`mergeable` says there is no conflict. `BLOCKED` says a rule is still unsatisfied. `REVIEW_REQUIRED` names one of them.

Check the required checks and the branch rules:

```bash
gh pr checks 128 --required
gh ruleset check main
```

If review is the only missing gate, request a reviewer:

```bash
gh pr edit 128 --add-reviewer ada
```

If the branch is behind the base and the rules require it to be current, update it:

```bash
gh pr update-branch 128
```

If the pull request is still a draft, mark it ready:

```bash
gh pr ready 128
```

When the remaining gates are satisfied, merge or enable auto-merge:

```bash
gh pr merge 128 --squash --auto
```

`--auto` waits for the requirements. It does not skip them. If the repository uses a merge queue, the pull request enters the queue when it is ready.
