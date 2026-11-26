---
type: Example
title: Checking what Git ignores
---

`git status` hides ignored files, which can make a wrong pattern hard to spot. Two commands help.

`git status --ignored` lists ignored paths alongside the normal status:

```text
$ git status --ignored
On branch main
Ignored files:
  (use "git add -f <file>..." to include in what will be committed)
	node_modules/
	.env
```

`git check-ignore -v path` explains why a path is ignored:

```text
$ git check-ignore -v .env
.gitignore:4:.env	.env
```

The output names the file, line number, and pattern that matched. If a path you expected to be ignored is not listed, the pattern probably does not match, or the file is already tracked. `git add -f path` overrides an ignore rule, but use it deliberately: forcing a generated or secret file into a commit is rarely what you want.
