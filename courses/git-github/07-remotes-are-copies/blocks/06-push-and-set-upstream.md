---
type: Commands
title: Push and set upstream
---

| Command | What it does |
| --- | --- |
| `git push -u origin main` | Push `main` and set `origin/main` as its upstream |
| `git push` | Push the current branch to its upstream |
| `git push origin main` | Push to a named remote and branch |
| `git push origin --delete <branch>` | Delete a branch on the remote |
| `git push --tags` | Push tags that are not on the remote yet |

`git push` uploads commits that the remote does not have. It does not upload uncommitted changes, untracked files, or local configuration. A push updates a remote branch, so the remote's history must be able to fast-forward to yours; if it cannot, Git rejects the push.

`-u` sets the upstream on the first push. After that, `git push` on the same branch knows where to go. `git push origin main` is the explicit form and works without an upstream.

Deleting a remote branch is separate from deleting a local one. `git push origin --delete feature` removes the branch on the remote; your local `feature` stays until you delete it too.

Tags are not pushed by a normal branch push. Use `git push --tags` for all tags, or `git push --follow-tags` to push annotated tags reachable from the commits you are pushing.
