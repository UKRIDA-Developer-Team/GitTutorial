---
type: Explain
title: The reflog finds lost commits
---

The reflog is a local record of where `HEAD` and branch references have pointed. Every commit, switch, merge, rebase, and reset adds an entry. It is the safety net behind operations that move labels.

```text
$ git reflog
a1b2c3d HEAD@{0}: reset: moving to HEAD~1
d4e5f6a HEAD@{1}: commit: Add greeting
9c8b7a6 HEAD@{2}: commit: Add README
```

Read it from the bottom up. `HEAD@{1}` was the commit before the reset; `HEAD@{0}` is where `HEAD` points now. The hash on the left is the commit that the entry recorded.

`git reflog` shows `HEAD`'s history. `git reflog show main` shows one branch's history. The reflog is local: it is not pushed, and another clone has its own. Entries expire after a period set by Git's configuration, so it is a recovery window, not permanent storage.

The reflog can recover commits that lost their labels. It cannot recover uncommitted changes, because those were never commits.
