---
type: Warning
title: First-commit errors
---

First commits fail for a few predictable reasons.

- **Identity is not set.** Git refuses to commit and asks for `user.name` and `user.email`. Set them before committing.
- **Nothing is staged.** `git commit` says there are no changes added to the commit. Run `git add` first, or use `git commit -a` for tracked files; `-a` does not include new untracked files.
- **The wrong folder.** If `git status` says `not a git repository`, you are outside the repository or `git init` was never run. Check `pwd` and `ls -a`.
- **A secret is staged.** `.gitignore` does not help after `git add`. Unstage the file with `git rm --cached .env` before the first commit, or `git restore --staged .env` after a commit exists. Then add it to `.gitignore`, and rotate the secret if it was already pushed.
- **Generated files are staged.** `node_modules/` and `dist/` can make the first commit enormous. Ignore them before the first `git add .`.
