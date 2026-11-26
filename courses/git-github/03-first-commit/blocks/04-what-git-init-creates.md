---
type: Explain
title: What git init creates
---

`git init` creates a `.git` directory and writes a small amount of configuration. The important entries are:

- `HEAD`, a file that names the current branch, for example `ref: refs/heads/main`.
- `config`, repository-local settings such as remotes and branch configuration.
- `objects/`, the content-addressed store for commits, trees, and file contents, keyed by hash.
- `refs/`, where branch and tag labels live.
- `index`, the staging area, created when you first stage something.

The folder around `.git` is the working tree. Git does not track the folder itself; it tracks files inside it. Files outside the repository are invisible to Git.

`git init` is safe to run in an existing folder. It does not delete files or create a commit, and it does not contact a server. The repository is local until you add a remote and push.
