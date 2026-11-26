---
type: Example
title: From empty folder to first commit
---

After `git init`, create a file and check status:

```text
$ echo "# Recipes" > README.md
$ git status
On branch main

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
	README.md

nothing added to commit but untracked files present (use "git add" to track)
```

Stage it and inspect what will be committed:

```text
$ git add README.md
$ git diff --staged
diff --git a/README.md b/README.md
new file mode 100644
index 0000000..1a2b3c4
--- /dev/null
+++ b/README.md
@@ -0,0 +1 @@
+# Recipes
```

Commit:

```text
$ git commit -m "Add README"
[main (root-commit) a1b2c3d] Add README
 1 file changed, 1 insertion(+)
 create mode 100644 README.md
```

Check the result:

```text
$ git log --oneline
a1b2c3d Add README

$ git status
On branch main
nothing to commit, working tree clean
```

The `root-commit` label means this commit has no parent. The hash `a1b2c3d` is shortened; your hash will be different. The working tree is clean because the committed snapshot matches the files on disk.
