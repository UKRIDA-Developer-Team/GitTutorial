---
type: Explain
title: Clone creates a local copy
---

`git clone <url>` creates a new local repository from a remote one. It copies the commits and tags, records the remote's branches as remote-tracking branches, adds a remote named `origin`, and checks out the remote's default branch as a local branch.

The clone sets up two related things. `origin/main` is a remote-tracking branch: your local record of where `main` was on `origin` when the clone finished. Your local `main` is a separate branch that starts at the same commit and is configured to track `origin/main`. The names look similar, but they are different refs. You commit to `main`; `origin/main` moves when you fetch or push.

A clone does not copy uncommitted changes or untracked files. It copies recorded history, not the state of someone's working tree. It is also not a backup of your local work: a clone of a remote contains only what has been pushed.

You can clone from a URL, a local path, or a hosting platform's page. The transport changes; the result is the same kind of repository with an `origin` remote.
