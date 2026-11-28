---
type: Diagram
title: A conflict records both versions
---

![Three boxes show the base version, the current branch version, and the merged branch version. Below them, a file contains both edits separated by conflict markers: seven less-than signs and HEAD, the current branch text, seven equals signs, the other branch text, and seven greater-than signs and the branch name.](../media/blocks/conflict-markers/conflict-markers.svg)

Git writes both versions into the file between markers. You edit the file to the result you want, remove the markers, stage the file, and commit.
