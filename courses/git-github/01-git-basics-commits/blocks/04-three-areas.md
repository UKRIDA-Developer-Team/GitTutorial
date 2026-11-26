---
type: Explain
title: The three areas
---

Git keeps three related things:

- The **working tree** is the set of files you see and edit in your project folder. It includes tracked and untracked files.
- The **index**, also called the staging area, is the selection of changes that the next commit will record. It is a real file inside `.git`, not just a concept.
- The **repository** is the stored history of commits, also inside `.git`.

When you change a file, the working tree differs from the index and from the last commit. When you stage a change, you copy that version into the index. When you commit, Git records the index as a new snapshot.

The index is the part that surprises people. It means you can edit five files but commit only two, or edit a file again after staging it and commit the earlier staged version. It also means a commit is a deliberate selection, not a photograph of whatever happened to be on disk.

`git status` compares these three places. It tells you what differs between the working tree and the index, and between the index and the last commit.
