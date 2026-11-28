---
type: Explain
title: Secret and code scanning
---

Secret scanning looks for credentials in repository content and history, such as tokens, private keys, and cloud access keys. Push protection can block a supported secret before it is pushed. When a secret is found, the alert names the location and the kind of credential.

Revoke the secret first. Removing it from the latest commit does not remove it from earlier commits, forks, clones, caches, or logs. Rotate the credential, then clean the history if the exposure requires it, and tell the people who depend on the old value.

Code scanning runs static analysis on the code, usually through CodeQL or a third-party tool that uploads SARIF results in CI. It reports findings with a location, severity, and rule. Fix the finding or record why it is a false positive; do not dismiss alerts just to make the count zero.

Scanning is detection, not proof of safety. It finds patterns it knows about. A clean scan does not mean the code has no vulnerabilities, and a finding is not always exploitable.

Dependency alerts, secret scanning, and code scanning are separate features with separate alerts. A repository can enable one without the others. Treat each finding as a task with an owner, not as background noise.
