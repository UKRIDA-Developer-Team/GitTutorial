---
type: Explain
title: Reading commit output
---

`git commit` prints a compact summary. In `[main (root-commit) a1b2c3d] Add README`:

- `main` is the branch that moved.
- `root-commit` means the commit has no parent.
- `a1b2c3d` is the shortened commit hash.
- `Add README` is the subject line.

The next lines count what changed: one file, one insertion, and the new file's mode. `create mode 100644` means a regular, non-executable file.

`git log --oneline` shows the hash and subject for each commit, newest first. `git log` without `--oneline` adds the author, date, and full message. `git log --stat` adds the changed-file summary, and `git log --patch` adds the diff. `git show HEAD` shows the newest commit and its diff.

The hash is derived from the commit contents. If you amend the message or change a file, the new commit gets a different hash. Do not expect the example hash to match yours.
