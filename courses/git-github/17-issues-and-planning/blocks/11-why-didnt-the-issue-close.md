---
type: Question
title: Why didn't the issue close?
---

A pull request merged, but its issue is still open. The description says `Related to #42`. What went wrong?

`Related to` is a reference, not a closing keyword. GitHub closes an issue only when a closing keyword such as `Closes #42`, `Fixes #42`, or `Resolves #42` appears in the pull request description or in a commit that reaches the default branch.

Other common causes:

- The pull request merged into a branch other than the default branch. Closing keywords take effect on the default branch.
- The issue is in a different repository, so the pull request's keyword may point at a different tracker. Link it explicitly and confirm which issue should close.
- The keyword has a typo, or the number points at a pull request instead of the issue.
- The issue was already closed and then reopened, so the old link no longer applies.

Check the issue timeline and the pull request's linked issues. If the work is complete, edit the pull request body to use `Closes #42` before merging, or close the issue with a comment that points at the merge.
