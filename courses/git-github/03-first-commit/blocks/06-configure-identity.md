---
type: Commands
title: Configure your identity
---

| Command | What it does |
| --- | --- |
| `git config --global user.name "Your Name"` | Set the author name used in new commits |
| `git config --global user.email "you@example.com"` | Set the author email used in new commits |
| `git config --global init.defaultBranch main` | Use `main` as the initial branch for new repositories |
| `git config --global --list` | Show your global Git configuration |
| `git config --show-origin --get user.email` | Show which file supplies the email value |

`--global` applies to all repositories for your user account. Without it, `git config` writes to the current repository only. A repository-specific value overrides the global one.

Run these commands before your first commit. Git refuses to commit without a name and email, and the values become part of every commit you create.
