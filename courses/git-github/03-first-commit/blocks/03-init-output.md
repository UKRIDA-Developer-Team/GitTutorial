---
type: Example
title: An empty repository
---

Create a folder, enter it, and initialize it:

```bash
mkdir recipes
cd recipes
git init
```

Git prints something like:

```text
Initialized empty Git repository in /home/you/recipes/.git/
```

List the folder, including hidden entries:

```text
$ ls -a
.  ..  .git
```

The `.git` directory is the repository. `git status` confirms the state:

```text
$ git status
On branch main

No commits yet

nothing to commit (create/copy files and use "git add" to track)
```

The repository exists, but it has no commits. Git may call the initial branch `main` or `master` depending on your configuration and Git version. The name does not change how commits work. You can set the default for new repositories with `git config --global init.defaultBranch main`, or rename the current branch with `git branch -m main`.
