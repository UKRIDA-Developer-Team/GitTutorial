---
type: Example
title: A feature branch in practice
---

Start on `main` with a clean working tree and create a branch:

```bash
git switch -c add-greeting
```

Edit a file and commit on the new branch:

```bash
echo "Hello, world" > greeting.txt
git add greeting.txt
git commit -m "Add greeting"
```

Switch back to `main`:

```bash
git switch main
```

`git log --oneline` now shows only the commits on `main`; the greeting commit is not there. The commit still exists on `add-greeting`. Show both lines of history with:

```bash
git log --oneline --graph --all --decorate
```

The `--all` flag includes every branch, and `--decorate` shows the labels. Switching back to `add-greeting` restores the file that the branch's commit contains.

Deleting the branch later removes the label, not the commit, as long as another reference still reaches it.
