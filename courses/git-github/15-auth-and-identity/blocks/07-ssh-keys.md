---
type: Explain
title: SSH keys
---

SSH authentication uses a key pair. The private key stays on your machine; the public key is added to your GitHub account. Git proves that you hold the private key without sending it over the network.

Create an Ed25519 key with `ssh-keygen -t ed25519 -C "you@example.com"`. The comment is a label, not a credential. A passphrase encrypts the private key at rest; the SSH agent can hold the unlocked key for a session so you do not retype the passphrase for every push.

Add the contents of the public key, the file ending in `.pub`, to your GitHub account. The private key must never leave your machine or be committed. `gh auth login --git-protocol ssh` can detect an existing key and offer to upload it, or create one when none exists.

Test the connection with `ssh -T git@github.com`. A successful test prints a message that greets your username and says GitHub does not provide shell access. That message is the expected result; it is not an error.

An SSH remote looks like `git@github.com:OWNER/REPO.git`. It uses the same repository and history as the HTTPS URL; only the transport changes. Switch an existing clone with `git remote set-url`.
