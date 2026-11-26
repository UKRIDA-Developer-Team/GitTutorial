---
type: Question
title: What goes into the first commit?
---

You run `git add README.md`, then edit `README.md` again. You also create `notes.txt`, and your `.gitignore` contains `.env`. Then you run `git commit -m "Add README"`.

What does the commit contain?

It contains the version of `README.md` that was staged, not the newer edit. It does not contain `notes.txt`, because that file is untracked. It does not contain `.env`, because `.gitignore` excludes it. To include the newer `README.md`, run `git add README.md` again before committing.
