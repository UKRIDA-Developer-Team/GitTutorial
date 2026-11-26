---
type: Explain
title: Remotes are other copies
---

A remote is another copy of a repository, usually on a server. Git stores a remote as a name and a URL, and `origin` is the conventional name for the copy you cloned from.

A remote is a full repository, not a folder of files. It has its own commits, branches, and tags. Your local repository keeps remote-tracking branches such as `origin/main`, which record where `main` was on the remote the last time you fetched. They are read-only locally; you do not commit to `origin/main`.

`git fetch` downloads new commits and updates remote-tracking branches without changing your branches or working tree. `git push` uploads your commits to a remote branch. `git pull` fetches and then combines the remote work into your current branch, usually with a merge or a rebase depending on configuration.

A fork is a copy of someone else's repository on a hosting platform. A pull request is a request to merge one branch into another on that platform. Both are collaboration features built around Git repositories; neither is a core Git command.
