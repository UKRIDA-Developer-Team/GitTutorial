---
type: Question
title: Why is merge disabled when checks pass?
---

`gh pr checks 128 --required` is green, and `gh pr view` reports `"mergeable": "MERGEABLE"`, yet the merge is blocked. What else can block it?

`mergeable` only means Git can combine the branches without a conflict. It does not mean policy allows the merge. A blocked state can come from a missing review, a stale approval, a code-owner review, a draft state, a branch that is behind, or a required merge queue.

Read the review state and the rules:

```bash
gh pr view 128 --json reviewDecision,mergeStateStatus,mergeable
gh ruleset check main
```

`reviewDecision: REVIEW_REQUIRED` means an approval is still needed. `mergeStateStatus: BEHIND` means the base moved and the rules require an update. `BLOCKED` with an approved review often points at a code-owner rule or another required check that is not in the list you inspected.

Fix the missing gate, then merge or enable auto-merge. Do not treat an administrator bypass as a diagnosis.
