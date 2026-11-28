---
type: Example
title: Squashing commits
---

A feature branch has three commits:

```text
$ git log --oneline
9a0b1c2 Add test
5d6e7f8 Fix typo
1a2b3c4 Add greeting
```

Start an interactive rebase over the last three commits:

```bash
git rebase -i HEAD~3
```

The todo list opens:

```text
pick 1a2b3c4 Add greeting
pick 5d6e7f8 Fix typo
pick 9a0b1c2 Add test
```

Change the second and third lines to `squash`:

```text
pick 1a2b3c4 Add greeting
squash 5d6e7f8 Fix typo
squash 9a0b1c2 Add test
```

Save and close the editor. Git combines the three changes and opens an editor for the combined message. Write a message such as `Add greeting and test`, then save.

The branch now has one commit instead of three:

```text
$ git log --oneline
7c8d9e0 Add greeting and test
```

The new commit has a new hash. The old three are still in the reflog, and `ORIG_HEAD` points to the pre-rebase tip.
