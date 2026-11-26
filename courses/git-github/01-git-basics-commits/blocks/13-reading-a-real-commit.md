---
type: Example
title: Reading a real commit
---

`git show` prints a commit's metadata and the diff it introduced. `git cat-file -p` prints the raw commit object, which makes the structure visible:

```text
$ git cat-file -p HEAD
tree 93b1f2c4d5e6a7b8c9d0e1f2a3b4c5d6e7f8a9b0
parent 9fceb029e7b6c1f0f6a3d2b1c0e9f8a7b6c5d4e3
author Ada Lovelace <ada@example.com> 1727356800 +0000
committer Ada Lovelace <ada@example.com> 1727356800 +0000

Add README
```

The `tree` line points to the snapshot, the `parent` line points to the previous commit, and the two identity lines record who wrote and applied the change. The blank line separates the headers from the message.

The hash you see in `git log` is the hash of this object. It is not stored inside the object; Git computes it from the content. That is why any change to the tree, parent, author, or message produces a different hash.
