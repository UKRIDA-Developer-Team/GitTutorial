---
type: Warning
title: Resolving without understanding
---

A conflict is a question, not a mess to clear. Deleting the marker lines without deciding the content produces a file that compiles or parses but silently drops one side's change.

- Do not commit while marker lines remain. Search the file for `<<<<<<<`, `=======`, and `>>>>>>>` before staging it.
- Do not take "ours" or "theirs" for a whole file unless you have read both versions. The side you discard may contain the fix.
- Do not assume a clean merge is a correct merge. Git checks lines, not meaning. Run the tests or build after resolving.
- Do not resolve by copying a file from one branch without checking what the other branch changed. That is the same as choosing a side without reading it.
- If you are unsure, `git merge --abort` and ask. Aborting is cheap; a bad merge commit is not.

The merge commit records the resolution, so the next person sees the result, not the reasoning. Put the reason in the commit message when the resolution is not obvious.
