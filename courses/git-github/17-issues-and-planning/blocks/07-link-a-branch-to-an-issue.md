---
type: Explain
title: Link a branch to an issue
---

A branch name can mention an issue, such as `42-fix-install-command`, but the name alone does not create a link. The link is platform metadata.

`gh issue develop 42 --name fix-install-command --base main --checkout` creates a branch from `main`, records it as a linked branch for issue 42, and checks it out. The branch is still an ordinary Git branch; the link is stored by GitHub.

A pull request links to an issue through its body. Write `Closes #42` or `Fixes #42` in the description. When the pull request merges into the default branch, GitHub closes issue 42 and adds a reference to the merge. The same keywords work in a commit message that reaches the default branch.

Use `Related to #42` when the pull request is part of the work but should not close the issue. Use a closing keyword only when the merge really completes the issue. A link that closes too early hides remaining work; a link that never closes leaves the tracker stale.
