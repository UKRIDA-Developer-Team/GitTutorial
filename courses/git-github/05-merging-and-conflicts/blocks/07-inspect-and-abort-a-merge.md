---
type: Commands
title: Inspect and abort a merge
---

| Command | What it does |
| --- | --- |
| `git status` | List the unmerged paths and the merge state |
| `git diff` | Show the conflict hunks in the working tree |
| `git restore --ours <file>` | Take the current branch's version of a conflicted file |
| `git restore --theirs <file>` | Take the merged branch's version of a conflicted file |
| `git merge --abort` | Stop the merge and restore the pre-merge state |
| `git merge --continue` | Continue after you have resolved and staged the conflicts |

`git merge --abort` works only while a merge is in progress. It restores the working tree and index to the state before the merge started. Uncommitted work that existed before the merge is preserved; changes made while resolving are discarded.

`git restore --ours` and `--theirs` take a whole file from one side. That is useful when one side's version is clearly correct, but it drops the other side's changes to that file. Read the diff before using them. The older spelling is `git checkout --ours` and `git checkout --theirs`.

After you stage the resolved files, `git merge --continue` finishes the merge. It is equivalent to `git commit` in this state, but it checks that no unmerged paths remain.
