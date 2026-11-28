---
type: Commands
title: Set your commit identity
---

| Command | What it does |
| --- | --- |
| `git config --global user.name "Ada Lovelace"` | Set the author name for all repositories |
| `git config --global user.email "ada@example.com"` | Set the author email for all repositories |
| `git config --local user.email "ada@work.example"` | Override the email in the current repository |
| `git config --show-origin --get user.email` | Show the email and the file that sets it |
| `git log -1 --format='%an <%ae>'` | Show the author of the latest commit |

`user.name` is the name written into commits, not your GitHub username. Use the name you want public. The email should be one you control; GitHub associates a commit with an account only when the author email matches an address on that account.

If you do not want your real address in public history, GitHub can provide a no-reply address of the form `ID+username@users.noreply.github.com`. Set it as `user.email` and GitHub will link the commits to your account without exposing your mailbox.

Configuration affects new commits. Existing commits keep the identity they were created with. Rewriting an old commit changes its hash, so correct the setting before you start a branch rather than rewriting history afterward.
