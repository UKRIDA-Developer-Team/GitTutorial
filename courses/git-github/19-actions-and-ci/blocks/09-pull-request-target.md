---
type: Warning
title: pull_request_target runs trusted
---

`pull_request_target` runs in the context of the base repository. It has the base repository's secrets and a token that may write. It is triggered by pull requests, including pull requests from forks.

That combination is dangerous when the workflow checks out the pull request's code and runs it. The code comes from the contributor; the secrets and token belong to the base repository. A malicious pull request can read the secrets or use the token before anyone reviews the change.

Use `pull_request` to build and test code from a fork. It gets a read-only token and no secrets, which is exactly what untrusted code should have.

If you need `pull_request_target` for metadata work, such as labeling or commenting, do not check out and execute the head branch. If you must inspect the code, treat it as data: read it with restricted permissions, do not run its scripts, and do not expose secrets to it. Grant the smallest `permissions` block that the job needs.

Secret masking is not a security boundary. A workflow that prints a secret can still leak it in a transformed form.
