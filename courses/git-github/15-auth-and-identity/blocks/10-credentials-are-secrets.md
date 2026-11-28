---
type: Warning
title: Credentials are secrets
---

A token or private key is a password. Anyone who has it can act as your account within its permissions.

- Never put a token in a remote URL, a commit, an issue, a log line, or a screenshot.
- Avoid `git config --global credential.helper store` on a shared or untrusted machine. It writes credentials in plain text.
- Prefer `gh auth login`, an operating-system keychain, or an SSH agent. Use a passphrase on SSH keys.
- Give tokens the narrowest scope and the shortest expiry that still work. Revoke tokens you no longer use.
- Log out on shared machines with `gh auth logout` and remove keys from the agent with `ssh-add -d`.
- If a token leaks, revoke it first, then rotate it. Removing it from the latest commit is not enough if it remains in history or in a fork.
- Do not disable TLS certificate checks to make a failing connection work. Fix the trust problem instead.

Authentication failures are often permission failures in disguise. Check the account and its access before creating a broader token.
