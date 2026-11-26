---
type: Explain
title: What a commit contains
---

A commit records the state of every tracked file at one moment. That state is stored as a tree: a directory-like structure of file names, file contents, and subdirectories. The commit points to the tree, not to your working folder.

A commit also contains:

- **A parent.** The previous commit, so history forms a chain. The first commit in a repository has no parent and is called the root commit. A merge commit has two or more parents.
- **An author.** The name, email, and timestamp of the person who wrote the change.
- **A committer.** The person who applied it, with a timestamp. For a normal local commit, author and committer are the same. Rebasing or applying someone else's patch can make them differ.
- **A message.** The explanation of why the change exists.
- **A hash.** A long identifier derived from the commit's contents. Change the message, the author, or a file, and the hash changes.

The hash is why history is hard to alter silently. Each commit's hash includes its parent's hash, so rewriting an old commit changes every later hash. Git can detect that the chain no longer matches.

The author name and email are part of the commit itself, not just your local settings. Git uses the name and email from your configuration when it creates a commit.
