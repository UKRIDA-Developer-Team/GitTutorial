---
type: Explain
title: Branch protection and rulesets
---

Branch protection rules and rulesets are platform policies that apply to branches matching a pattern. They can require pull requests, a number of approvals, review from code owners, passing status checks, a linear history, signed commits, or a merge queue. They can also block force-pushes and branch deletion.

Branch protection is the older mechanism. Rulesets are the newer one: they can target branches and tags, apply at the organization level, run in an evaluate mode before enforcement, and name bypass actors. A repository can have both. GitHub evaluates every applicable rule, so a merge must satisfy the union of them.

A ruleset can also require that a branch be up to date before merging. That closes a gap: a pull request tested against an old base may pass while the same changes fail against the current base. The cost is that every base update can require the author to update the branch and rerun checks.

Rules are not suggestions. If a required review is missing, a required check is failing or pending, or the branch is behind, the platform blocks the merge even when the code looks correct. Administrators may have a bypass, but using it skips the safety the team agreed on.
