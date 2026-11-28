---
type: Explain
title: Tracking branches
---

A remote-tracking branch such as `origin/main` is a local ref that records where the remote's `main` was the last time you fetched. You do not commit to it. It moves when `git fetch` downloads new commits, or when `git push` updates the remote.

Your local branch can track a remote-tracking branch. That link is called the upstream. When `main` tracks `origin/main`, `git status` can report whether you are ahead, behind, or both, and `git push` and `git pull` can use the upstream without naming the remote and branch every time.

Set the upstream on the first push:

```bash
git push -u origin main
```

Or set it later:

```bash
git branch --set-upstream-to=origin/main main
```

`git branch -vv` lists each local branch with its upstream and ahead/behind counts. `git status` prints a plain-language version: "Your branch is up to date with 'origin/main'", "ahead of 'origin/main' by 1 commit", or "have diverged".

Tracking is a convenience, not a requirement. You can always name the remote and branch explicitly, such as `git push origin main`. The upstream just makes the common case shorter.
