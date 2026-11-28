---
type: Explain
title: Workflow anatomy
---

A workflow is a YAML file in `.github/workflows/`. It has a name, one or more events that trigger it, optional permissions and environment variables, and one or more jobs.

A job runs on a runner: a fresh virtual machine or container provided by GitHub. Jobs are independent by default and can run in parallel. A job contains steps, which run in order. A step either runs a shell command with `run` or uses a reusable action with `uses`.

An action is a packaged unit of work, such as checking out the repository or installing Node.js. Actions can come from GitHub, from a marketplace publisher, or from the same repository. Pin third-party actions to a commit SHA when supply-chain security matters; a tag can move.

The runner starts clean. It does not have your uncommitted files, your local environment variables, or your installed tools unless the workflow puts them there. That is why a workflow checks out the repository and installs dependencies explicitly.

Results become checks attached to the commit or pull request. Branch protection can require those checks before a merge, which is how CI becomes a merge gate.
