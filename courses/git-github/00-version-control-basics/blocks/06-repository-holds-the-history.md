---
type: Explain
title: A repository holds the history
---

A repository is the database that holds a project's recorded history and its metadata. In Git, a repository is usually the hidden `.git` directory inside the project folder. The folder you work in is the working tree; `.git` is the history.

The distinction matters. Deleting `.git` deletes the history, even though your files remain. Copying the folder without `.git` copies the current files but none of the commits. Committing adds to `.git`, and `git log` reads from it.

A repository can be local or remote, and the two are copies of the same history. `git clone` creates a new local repository from a remote one, including its commits. A repository can hold one project and thousands of commits.

The repository also stores references to commits, including branches and tags, plus configuration and the index, which is a staging area for the next commit. The working tree is the part you edit; the repository is the part that remembers.
