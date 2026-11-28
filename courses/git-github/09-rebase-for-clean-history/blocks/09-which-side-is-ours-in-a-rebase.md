---
type: Question
title: Which side is ours during a rebase?
---

You are rebasing `feature` onto `main`. A conflict shows:

```text
<<<<<<< HEAD
Hello from main
=======
Hello from feature
>>>>>>> 7d1e0ab (Add greeting)
```

Which side is your work?

"Ours" is `main`, the new base you are rebasing onto. "Theirs" is the commit from `feature` being replayed. During a rebase, `HEAD` is detached on the new base, so the first marker names the base, not your branch.

This is the reverse of a merge, where "ours" is the branch you are on. If you are unsure, run `git status` to see the rebase state, or `git rebase --abort` and inspect before trying again.
