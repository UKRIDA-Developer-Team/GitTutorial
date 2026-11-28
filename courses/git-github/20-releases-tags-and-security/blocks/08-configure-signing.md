---
type: Commands
title: Configure signing
---

| Command | What it does |
| --- | --- |
| `git config --global gpg.format ssh` | Use SSH keys for signing |
| `git config --global user.signingkey ~/.ssh/id_ed25519.pub` | Select the public key |
| `git config --global commit.gpgsign true` | Sign every new commit |
| `git config --global tag.gpgSign true` | Sign annotated tags by default |
| `git tag -s v1.4.0 -m "Release v1.4.0"` | Create a signed tag |
| `git commit -S -m "..."` | Sign one commit |
| `git verify-tag v1.4.0` | Verify a tag's signature |
| `git log --show-signature -1` | Show the latest commit's signature |

For SSH signing, add the public key to GitHub as a signing key. The same key can also be registered for authentication, but the two uses are separate entries. Git 2.34 or newer is needed for SSH signing.

For GPG signing, generate a key, export the public part in ASCII armor, add it to GitHub, and set `user.signingkey` to the key ID. The default `gpg.format` is OpenPGP, so the SSH settings are only for SSH keys.

`commit.gpgsign true` makes every commit depend on the key. If the key is missing or the agent cannot unlock it, the commit fails rather than creating an unsigned commit silently. That is usually the right failure mode for a repository that requires signatures.

Existing commits and tags are not retroactively signed. Re-signing rewrites the object and changes its hash, so do it before publishing, not after users depend on the tag.
