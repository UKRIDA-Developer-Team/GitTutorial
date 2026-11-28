---
type: Example
title: "Milestone 2: build and commit"
---

Implement the filter and its tests, then inspect the change:

```bash
git status
git diff
```

Stage the code and tests together, because they belong to one logical change:

```bash
git add src/search.js src/search.test.js
git commit -m "Add vegetarian filter to recipe search"
```

Update the README as a separate, focused commit:

```bash
git add README.md
git commit -m "Document vegetarian search filter"
```

Run the test suite before moving on:

```bash
npm test
```

The history should show two clear commits:

```text
$ git log --oneline -3
b7c1e42 Document vegetarian search filter
a91d3f0 Add vegetarian filter to recipe search
5e2c8b1 Update recipe categories
```

A good commit is a coherent change with a message that says what it does. Do not mix a refactor, a dependency upgrade, and the feature in one commit. If a commit is wrong, fix it now with `git commit --amend` or an interactive rebase while the branch is still local.

The feature is not done until the tests pass and the README is accurate. A commit is a checkpoint, not proof of correctness.
