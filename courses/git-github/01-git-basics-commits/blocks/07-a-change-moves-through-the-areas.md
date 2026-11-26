---
type: Example
title: A change moves through the areas
---

Start with a tracked file, `app.js`, that matches the last commit.

1. Edit `app.js` in the working tree. `git status` reports `modified: app.js` under "Changes not staged for commit." The index still holds the committed version.
2. Run `git add app.js`. The edited version is copied into the index. Status reports `modified: app.js` under "Changes to be committed."
3. Edit `app.js` again. The working tree now has a newer version, but the index keeps the staged one. Status shows the file in both sections.
4. Run `git commit -m "Update greeting"`. The commit records the staged version. The newer edit remains in the working tree, still unstaged.

Each step changes one area. The commit is the version from step 2, not the version from step 3. This is why the order of `git add` and further edits matters.

At step 3, `git diff` shows only the newer edit, because it compares the working tree with the index. `git diff --staged` shows the staged version, because it compares the index with the last commit. Running both makes the split visible.
