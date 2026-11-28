---
type: Warning
title: Rebasing after you push
---

A rebase rewrites commits. If the branch is already on a remote and someone else has fetched it, your new history and theirs no longer match. Pushing the rebased branch requires a force-push, which replaces the remote branch instead of adding to it.

- Rebase branches you own and nobody else has based work on.
- Use `git push --force-with-lease` instead of `git push --force`. It refuses if the remote moved since your last fetch, so it will not overwrite commits you have not seen.
- Never force-push `main` or a protected branch.
- If you must rewrite a shared branch, tell everyone who uses it. They will need to reset or rebase their copies.
- Rebasing a pull request branch is usually safe when you are the only author, but it can detach review comments from the lines they were written on. Mention the rewrite when you update the pull request.

The safe default is unchanged: merge shared history, rebase your own unpublished work.
