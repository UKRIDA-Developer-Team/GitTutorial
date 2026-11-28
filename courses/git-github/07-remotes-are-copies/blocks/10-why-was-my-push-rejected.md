---
type: Question
title: Why was my push rejected?
---

You commit locally and run `git push`. Git rejects the push and says the remote contains work you do not have locally. What happened, and what should you do?

Someone pushed to the same branch after your last fetch. Your local branch and the remote branch have diverged: each has commits the other lacks. Git will not fast-forward the remote to your branch, because that would drop the other commits.

Fetch, inspect, and integrate:

```bash
git fetch
git log --oneline HEAD..origin/main
git pull --ff-only
```

If `--ff-only` fails, you have local commits of your own. Merge or rebase the remote branch, resolve any conflicts, and push again. Do not force the push; the remote is telling you that someone else's work is there.
