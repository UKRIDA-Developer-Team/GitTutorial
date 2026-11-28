---
type: Explain
title: Debug a failed run
---

Start with the failing job and step, not the whole log. `gh run view --log-failed` prints the failed steps, and `gh run view` shows which job and step failed. Read the first real error; later errors are often consequences.

Check the environment the runner actually had. The workflow may use a different language version, operating system, working directory, or set of environment variables than your machine. A file that exists locally but is ignored by Git will be missing after checkout. A dependency installed globally on your machine will be missing on a clean runner.

Check permissions and secrets next. A `403` usually means the token lacks a permission or the repository lacks access. A missing secret is empty rather than an error at startup, so the failure may appear later as an authentication error.

Rerun only when the failure looks transient: a network timeout, a registry outage, or a runner that lost its disk. A deterministic failure will fail again. If a rerun passes, note the flaky step so it can be fixed rather than tolerated.

Fix the workflow in a branch and let the pull request run it. Do not debug by pushing directly to a protected branch or by weakening the check that caught the problem.
