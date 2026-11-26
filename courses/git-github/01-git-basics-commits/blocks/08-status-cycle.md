---
type: Explain
title: The status cycle
---

Git describes a file's changes with four useful states:

- **Untracked:** the file is not in the last commit and has not been staged.
- **Modified:** a tracked file has changed in the working tree.
- **Staged:** the current version of a change is in the index and will be in the next commit.
- **Committed:** the change is recorded in a commit.

These describe changes, not permanent labels on a file. A file can be committed, then modified, then staged again. A tracked file is one Git already knows about from a commit or the index; staging a new file starts tracking it.

| From | Action | To |
| --- | --- | --- |
| Untracked | `git add` | Staged |
| Modified | `git add` | Staged |
| Staged | `git commit` | Committed |
| Committed | edit | Modified |
| Staged | edit again | Staged and modified |
| Modified | `git restore <file>` | Back to the index version |
| Staged | `git restore --staged <file>` | Back to the last committed version in the index |

`git status` reports which states your files are in. It does not change them. `git restore <file>` discards working-tree edits, while `git restore --staged <file>` removes a change from the index without touching the file.
