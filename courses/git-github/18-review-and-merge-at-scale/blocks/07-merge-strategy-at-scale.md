---
type: Explain
title: Merge strategy at scale
---

Chapter 08 introduced the three merge strategies. At scale, the question is not only which one works, but which one the repository can support consistently.

A squash merge creates one commit per pull request on the base branch. It keeps the base linear and makes each pull request easy to revert. The branch's individual commits disappear from the base history, which is fine when the pull request is the unit of change and the commits were only for development.

A merge commit preserves the branch and records that it was integrated. It is useful for long-lived branches, release integration, and work whose internal commits matter. On a busy base branch, it also adds a merge commit for every pull request, which some teams find noisy.

A rebase merge replays the branch's commits onto the base without a merge commit. It keeps history linear while preserving individual commits. It rewrites the commits, so it is a poor fit for branches other people have based work on, and it can invalidate commit signatures.

Choose one default, document it, and let the platform enforce the allowed methods. A repository that mixes strategies without a reason produces a history that is hard to read and harder to automate. `gh pr merge --squash` fails if the repository does not allow squash merges, so check the policy rather than assuming the flag is enough.
