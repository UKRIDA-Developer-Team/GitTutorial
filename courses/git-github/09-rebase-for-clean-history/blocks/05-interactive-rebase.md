---
type: Explain
title: Interactive rebase
---

`git rebase -i <base>` opens a list of the commits after `<base>` and lets you edit the list before Git replays it. The base is usually a branch or a commit such as `HEAD~3`.

Each line starts with a command:

- `pick` keeps the commit as it is.
- `reword` keeps the change but opens an editor for a new message.
- `edit` stops after applying the commit so you can amend it.
- `squash` combines the commit with the previous one and opens an editor for the combined message.
- `fixup` combines the commit with the previous one and discards its message.
- `drop` removes the commit.

You can reorder the lines, change a command, or delete a line. Git applies the list from top to bottom. A conflict can stop the process at any commit; resolve it, stage the file, and run `git rebase --continue`.

Interactive rebase rewrites the commits it touches, so use it on local work that nobody else has. It is the usual way to clean up a feature branch before opening or updating a pull request.
