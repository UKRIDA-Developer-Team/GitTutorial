---
type: Question
title: Which side is ours?
---

You are on `main` and run `git merge feature`. A conflict shows:

```text
<<<<<<< HEAD
Hello from main
=======
Hello from feature
>>>>>>> feature
```

Which side is "ours"?

"Ours" is `main`, the branch you are on and merging into. "Theirs" is `feature`, the branch being merged. `HEAD` still points to `main` during the merge, which is why the first marker names `HEAD`.

If you had switched to `feature` and merged `main`, the labels would swap. Read the marker lines instead of assuming that "ours" always means the same branch.
