---
type: Commands
title: Inspect and manage remotes
---

| Command | What it does |
| --- | --- |
| `git remote -v` | List remotes and their URLs |
| `git remote add <name> <url>` | Add a remote |
| `git remote rename <old> <new>` | Rename a remote |
| `git remote remove <name>` | Remove a remote and its remote-tracking branches |
| `git remote show origin` | Show details, including tracked branches |
| `git remote set-url origin <url>` | Change a remote's URL |

`origin` is a conventional name, not a special one. It is the name Git gives the remote you cloned from, and most tools assume it. A repository can have several remotes; `upstream` is a common second name when you work from a fork.

Adding a remote only records a name and a URL. It does not download anything. Run `git fetch <name>` to bring in that remote's commits and create its remote-tracking branches.

Removing a remote removes the name and its remote-tracking branches from your repository. It does not delete the remote repository, and it does not delete your local branches. If you remove `origin` by mistake, add it again with the same URL.
