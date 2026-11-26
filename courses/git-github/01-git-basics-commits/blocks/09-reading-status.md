---
type: Example
title: Reading status output
---

After you add a new file to a new repository, `git status` may show:

```text
On branch main

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
	README.md

nothing added to commit but untracked files present (use "git add" to track)
```

`No commits yet` means the repository exists but has no history. `Untracked files` lists files Git sees but does not yet follow.

After `git add README.md`, status changes:

```text
On branch main

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
	new file:   README.md
```

The file is now in the index. The `new file` label means it has no previous version in a commit.

If you edit `README.md` again without staging it, status shows it twice:

```text
Changes to be committed:
	new file:   README.md

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
	modified:   README.md
```

The staged line is the version that will be committed. The unstaged line is the newer edit in the working tree.

After the commit, the cycle can repeat. When nothing differs, status says:

```text
On branch main
nothing to commit, working tree clean
```

Clean means the working tree, the index, and the last commit agree.
