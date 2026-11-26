---
type: Question
title: Which version will be committed?
---

You stage `README.md`, then edit it again. Which version goes into the next commit?

The version that was in the working tree when you ran `git add`. The newer edit is only in the working tree, so it stays unstaged. To include it, run `git add README.md` again before committing.

This is the index doing its job: it holds the exact content you selected, even after the file on disk moves on.
