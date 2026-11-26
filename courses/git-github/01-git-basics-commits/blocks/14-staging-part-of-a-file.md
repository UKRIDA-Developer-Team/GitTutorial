---
type: Example
title: Staging part of a file
---

Staging does not have to mean staging a whole file. `git add -p` walks through each change hunk and asks whether to stage it:

```text
$ git add -p app.js
@@ -1,3 +1,4 @@
 function greet(name) {
-  return "Hello, " + name;
+  console.log("debug: greeting", name);
+  return "Hello, " + name;
 }
(1/1) Stage this hunk [y,n,q,a,d,s,e,?]?
```

Answer `y` to stage the hunk, `n` to skip it, or `s` to split it into smaller hunks. The result is an index that contains some of your edits and not others.

This is how you keep a commit focused. You can commit the real change now and leave the debug line in the working tree, then remove it before the next commit. `git diff --staged` shows exactly what you selected.
