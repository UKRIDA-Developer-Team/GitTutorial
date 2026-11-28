---
type: Explain
title: CODEOWNERS
---

A `CODEOWNERS` file maps paths to the people or teams responsible for reviewing them. A line such as `*.js @frontend-team` requests a review from that team when a pull request changes a JavaScript file. The file usually lives at `.github/CODEOWNERS`, with `CODEOWNERS` at the repository root as another supported location.

Patterns use a gitignore-like syntax. `*` matches everything, `docs/` matches that directory, and a later pattern overrides an earlier one. Order matters: the last matching pattern wins. Owners must be users or teams with write access to the repository, or GitHub cannot request their review.

CODEOWNERS does not grant permission and does not block a merge by itself. It only produces a review request. The block comes from a branch protection rule or ruleset that requires review from code owners.

Keep ownership current. A team that no longer exists, a path that moved, or an owner without access produces a request nobody can satisfy. That turns a safety rule into a permanent block.
