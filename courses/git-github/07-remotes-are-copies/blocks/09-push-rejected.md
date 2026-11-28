---
type: Warning
title: A rejected push is not a broken remote
---

A push is rejected when the remote branch has commits your branch does not have, or when your branch cannot fast-forward to the remote's tip. The usual message is:

```text
! [rejected]        main -> main (non-fast-forward)
error: failed to push some refs
hint: Updates were rejected because the tip of your current branch is behind
hint: its remote counterpart.
```

The remote is protecting history. It will not silently discard commits that someone else pushed. The fix is to integrate, not to force.

- Fetch first, then inspect with `git log HEAD..origin/main`.
- Merge or rebase the remote work into your branch, then push again.
- Do not use `git push --force` on a shared branch. It replaces the remote branch and can drop other people's commits.
- If you rewrote your own unpublished branch and must replace it, `git push --force-with-lease` is safer. It refuses if the remote moved since your last fetch, so it will not overwrite work you have not seen.

Force-pushing is a last resort for a branch only you use. For a shared branch, coordinate before rewriting anything.
