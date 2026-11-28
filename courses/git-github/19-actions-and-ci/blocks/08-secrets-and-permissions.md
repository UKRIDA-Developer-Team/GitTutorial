---
type: Explain
title: Secrets and permissions
---

`GITHUB_TOKEN` is created for each workflow run. It expires when the run ends and is scoped to the repository. Its permissions are controlled by the `permissions` key, at the workflow or job level. Set the narrowest permissions the job needs; a test job usually needs only `contents: read`.

Repository, organization, and environment secrets are stored encrypted and exposed as `secrets.NAME`. They are not printed in logs by default, but masking is best effort. A secret that is transformed, split, or written to a file can still leak. Never pass a secret to code you do not trust.

Workflows triggered by a pull request from a fork do not receive repository secrets, and their token is read-only. That protects the base repository from untrusted code. A maintainer who wants to run a privileged workflow after reviewing the code needs a deliberate, separate design, not a secret in the pull request workflow.

For cloud deployments, prefer short-lived OpenID Connect credentials over a long-lived cloud key stored as a secret. Grant `id-token: write` only to the job that needs it.

A secret is not a permission. A token with the right secret still fails if its scopes or repository access do not allow the action. Check both the secret and the permission when a workflow gets a `403`.
