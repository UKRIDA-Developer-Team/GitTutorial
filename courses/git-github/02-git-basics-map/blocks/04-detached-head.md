---
type: Example
title: A detached HEAD
---

Start on `main` at commit C3 and inspect an older commit:

```bash
git switch --detach C2
```

Git prints a warning that `HEAD` is detached. `git status` now says:

```text
HEAD detached at 2f4a1c9
```

The working tree matches C2. You can build, test, or inspect files without moving `main`.

If you commit while detached, Git creates a commit with `HEAD` pointing directly at it:

```text
$ git commit -m "Try older API"
[detached HEAD 7d1e0ab] Try older API
```

No branch points to `7d1e0ab`. Switching back to `main` leaves that commit reachable only through the reflog, a local log of where branches and `HEAD` have pointed, until it is garbage-collected. To keep it, create a branch there before switching away:

```bash
git switch -c rescue
```

When you are done inspecting, `git switch -` returns to the previous branch.
