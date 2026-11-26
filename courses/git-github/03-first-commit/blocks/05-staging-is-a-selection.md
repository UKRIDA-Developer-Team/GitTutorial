---
type: Explain
title: Staging is a selection
---

Some version control systems save the current state of a file as soon as you tell them to. Git separates choosing from recording. The index is the selection you build for the next commit.

Think of a photo album. The working tree is the folder containing every photo. The index is the set of photos you choose for the next page. The commit is the printed page. You can leave photos out, replace one before printing, or decide that a photo is not ready.

The analogy is not exact: Git records a snapshot of the selected file states, not a physical copy of each file. The useful part is that you choose what goes into a commit instead of saving everything in the working tree at once.

Staging also lets you split work. You can stage one file, one hunk of a file with `git add -p`, or one set of changes, and commit them separately from the rest. A hunk is a contiguous block of changed lines. A commit then tells one coherent story instead of mixing unrelated edits.
