---
type: Explain
title: An issue is a tracked conversation
---

An issue has a title, a description, an author, comments, labels, assignees, a milestone, and a state of open or closed. GitHub stores those fields in its database. They are not commits, refs, or files in your repository.

The issue is where work starts before there is code. It can describe a bug, a feature, a question, or a task. Comments record decisions and constraints that would otherwise live in chat. Links to commits and pull requests connect the discussion to the change, but the link is metadata on both sides, not part of the commit object.

Issues are searchable and can be referenced by number. `#42` in a comment, commit message, or pull request body points at issue 42 in the same repository. A cross-repository reference includes the owner and repository name.

Closing an issue does not delete a branch, revert a commit, or remove a pull request. It changes the issue's state. Reopening it changes the state back. The code and history are separate and remain where they were.
