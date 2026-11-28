---
type: Question
title: Why does it pass locally but fail in CI?
---

The test suite passes on your machine. The same commit fails in CI. What should you compare?

Compare the environment, not the code first. CI starts from a clean checkout on a fresh runner. Your machine may have uncommitted files, a different language version, globally installed tools, environment variables, credentials, or a case-insensitive filesystem.

Common causes:

- A file is ignored by Git, so it exists locally but not in the checkout.
- `package.json` and the lockfile disagree; `npm ci` refuses to install, while a local `npm install` silently updated the lockfile.
- A test depends on a local service, a port, a timezone, or network access that the runner does not have.
- A secret or environment variable is missing, so authentication fails later in the run.
- A path differs only by letter case, which works on macOS or Windows but fails on Linux.
- Tests share state and pass in one order locally but fail in parallel on the runner.

Reproduce with a clean clone and the same commands the workflow runs. If it still passes, compare the runner image and the workflow's environment. Fix the dependency or the workflow; do not hide the difference by disabling the check.
