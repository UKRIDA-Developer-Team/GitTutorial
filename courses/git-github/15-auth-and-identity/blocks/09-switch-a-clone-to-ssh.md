---
type: Example
title: Switch a clone from HTTPS to SSH
---

A clone uses HTTPS:

```text
$ git remote -v
origin  https://github.com/team/recipes.git (fetch)
origin  https://github.com/team/recipes.git (push)
```

Test SSH before changing anything:

```text
$ ssh -T git@github.com
Hi ada! You've successfully authenticated, but GitHub does not provide shell access.
```

Switch the remote and fetch:

```bash
git remote set-url origin git@github.com:team/recipes.git
git fetch origin
```

The history, branches, and commits do not change. Only the transport used to reach the same remote changes. `git remote -v` now shows the SSH URL.

If the test fails, fix the key before switching the remote. Otherwise every fetch and push will fail with a public-key error. `gh auth status` checks the `gh` credential, not the SSH key; `ssh -T` is the SSH test.
