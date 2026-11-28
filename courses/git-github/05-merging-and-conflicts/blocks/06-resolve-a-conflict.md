---
type: Example
title: Resolving a conflict
---

You are on `main` and merge `feature`. Both branches changed the greeting in `greeting.txt`:

```text
$ git merge feature
Auto-merging greeting.txt
CONFLICT (content): Merge conflict in greeting.txt
Automatic merge failed; fix conflicts and then commit the result.
```

`git status` lists the file under "Unmerged paths":

```text
Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   greeting.txt
```

Open `greeting.txt`. Git has written both versions into it:

```text
<<<<<<< HEAD
Hello from main
=======
Hello from feature
>>>>>>> feature
```

Edit the file to the content you actually want, and remove all three marker lines. For example:

```text
Hello from main and feature
```

Stage the resolved file and commit:

```bash
git add greeting.txt
git commit
```

Git opens an editor with a prepared merge message. Save it, or pass `-m` to supply your own. The merge commit now has two parents.

`git log --oneline --graph --decorate` shows the join. If you decide the merge was a mistake before committing, `git merge --abort` returns the branch to its pre-merge state.
