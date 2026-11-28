---
type: Explain
title: Merge queues
---

A merge queue serializes merges into a busy branch. Instead of merging each pull request directly, the queue builds a temporary merge of the pull request with the latest base and the pull requests ahead of it, then runs the required checks on that result. If the checks pass, the queue merges it. If they fail, the pull request leaves the queue and the author fixes it.

This solves the stale-base problem. Two pull requests can each pass alone and still break when combined. A queue tests the combination that will actually land, one at a time, without making every author rebase against every other author.

A queue is enabled by repository policy, not by a Git command. When it is required, `gh pr merge` adds the pull request to the queue if it is ready, or enables auto-merge if checks are still running. `--admin` can bypass the queue for an administrator, but that defeats the reason the queue exists.

Queue checks can fail for reasons that never appeared on the pull request, such as a semantic conflict with an earlier merge. Re-run the checks after fixing the branch, and re-add the pull request to the queue.
