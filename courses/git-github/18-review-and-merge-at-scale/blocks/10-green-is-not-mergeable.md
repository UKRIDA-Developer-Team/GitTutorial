---
type: Warning
title: Green is not mergeable
---

A passing check suite means the checks passed. It does not mean the pull request is allowed to merge.

- **Required review is missing.** A green run does not supply an approval.
- **The approval is stale.** A push after approval may dismiss it, depending on policy.
- **A code owner has not reviewed.** CODEOWNERS can add a required review that is easy to miss.
- **The branch is behind or conflicted.** Some rules require the branch to be current, and a conflict blocks the merge even when checks pass.
- **The pull request is a draft.** Drafts are visible and testable but not ready to merge.
- **The merge queue rejected it.** Queue checks run against a different base and can fail where the pull request passed alone.
- **A required check is pending or was skipped.** "All checks green" may refer to every check, not the required set. Use `gh pr checks --required`.

`gh pr merge --admin` can bypass some rules for an administrator. It is not a fix for a blocked pull request; it is a decision to skip the team's safety policy. Use it only when the policy explicitly allows it and the reason is recorded.

If the merge is blocked, read the state instead of retrying the button. `gh pr view --json reviewDecision,mergeStateStatus,mergeable` and `gh ruleset check` usually name the missing gate.
