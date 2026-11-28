---
type: Commands
title: Set up an SSH key
---

| Command | What it does |
| --- | --- |
| `ssh-keygen -t ed25519 -C "you@example.com"` | Create a key pair |
| `eval "$(ssh-agent -s)"` | Start the SSH agent in a Unix shell |
| `ssh-add ~/.ssh/id_ed25519` | Load the private key into the agent |
| `ssh -T git@github.com` | Test authentication with GitHub |
| `git remote set-url origin git@github.com:OWNER/REPO.git` | Switch the remote to SSH |
| `git remote -v` | Show the fetch and push URLs |

`ssh-keygen` writes the private key to `~/.ssh/id_ed25519` and the public key to `~/.ssh/id_ed25519.pub` by default. Upload the public file to GitHub, not the private one. If you choose a different path, use that path with `ssh-add` and in your SSH config.

On Windows, use the OpenSSH client included with Git for Windows and make sure the OpenSSH Authentication Agent service is running. The key usually lives under `%USERPROFILE%\.ssh\`. On macOS, the agent can store the passphrase in the keychain.

If `ssh -T` reports `Permission denied (publickey)`, the agent has no key, the key is not uploaded, or GitHub is matching a different key. Run `ssh-add -l` to see what the agent holds, then test again with `ssh -vT git@github.com` for the negotiation details.
