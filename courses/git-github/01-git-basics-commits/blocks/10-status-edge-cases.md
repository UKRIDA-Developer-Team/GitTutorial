---
type: Explain
title: Status edge cases
---

Status output has a few cases that confuse people.

**A deleted file.** Removing a tracked file shows as `deleted: file` under "Changes not staged for commit." `git add file` stages the deletion, so the next commit removes the file from the project. `git restore file` brings it back from the index.

**A renamed file.** Git does not record a rename as an operation. The new tree simply has the new path and not the old one. `git status` and `git log` detect a rename by comparing content, so they may show `renamed: old -> new` when the content is similar enough.

**An ignored file.** A file matching `.gitignore` does not appear in status at all. If it was already tracked, the ignore rule does not apply; it keeps appearing as modified.

**A file in both sections.** A staged file that you edit again appears under both "Changes to be committed" and "Changes not staged for commit." The two sections describe two different versions of the same path.

**A submodule or nested repository.** A submodule is a Git repository recorded inside another repository at a specific commit. Git reports the nested directory as a single entry, not as its files. It records a reference to another repository, not the contents of that repository.
