---
type: Example
title: Undoing a pushed change
---

A commit that changed the request timeout from 60 seconds to 30 seconds is already on `main` and pushed. The new value breaks a slow endpoint. You want the old value back without rewriting shared history.

Find the commit:

```text
$ git log --oneline
9c1d2e3 Change timeout to 30s
4b5a6f7 Add retry logic
1a2b3c4 Initial commit
```

Revert it:

```text
$ git revert 9c1d2e3
[main 7f8e9d0] Revert "Change timeout to 30s"
 1 file changed, 1 insertion(+), 1 deletion(-)
```

The new commit restores 60 seconds. Push it:

```bash
git push
```

History now contains both the change and its reversal. That is the point: anyone who already pulled the original commit gets the correction without their history being rewritten. The commit message records what was undone, and `git show 7f8e9d0` shows the reversal.
