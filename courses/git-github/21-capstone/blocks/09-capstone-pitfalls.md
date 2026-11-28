---
type: Warning
title: Capstone pitfalls
---

- **Working on `main`.** Create the branch before the first edit. A pull request from `main` to `main` has nothing to compare.
- **One giant commit.** Split code, tests, and documentation into coherent commits. A reviewer should be able to follow the change.
- **Skipping tests.** A commit is not done because it compiles. Run the suite before you push.
- **Ignoring review.** A requested change is part of the work, not an obstacle. Push the fix and respond.
- **Merging with red checks.** Green checks are a gate. Do not bypass them with `--admin` to finish faster.
- **Force-pushing a reviewed branch silently.** Rewriting the branch can detach review comments and invalidate approvals. Tell the reviewer what changed.
- **Tagging before the merge.** Tag the commit that is on `main` after the pull request merges, not the feature branch tip.
- **Moving a published tag.** Publish a new patch release instead of rewriting a version users already downloaded.
- **Forgetting to sync.** Local `main` does not move when the platform merges. Pull before tagging.
- **Publishing a secret.** Check the diff, the release assets, and the logs before a public release.

The capstone is not a race. A small, complete feature is a better result than a large, unfinished one.
