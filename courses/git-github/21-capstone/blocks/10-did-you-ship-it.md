---
type: Question
title: Did you ship it?
---

Run the checklist against the practice repository. If any answer is no, the project is not finished.

- Is the issue linked to the pull request and closed?
- Was the work done on a branch, not `main`?
- Does the history contain focused commits with meaningful messages?
- Did the branch integrate the latest `main` and pass the tests?
- Did a reviewer approve the pull request?
- Did the required checks pass before the merge?
- Is the pull request merged and the branch deleted?
- Does local `main` match `origin/main`?
- Is the tag annotated and pushed?
- Does the release point at that tag, with accurate notes?
- Is the working tree clean?

A yes to all is the definition of done. A release without a merged pull request, or a tag that points at a different commit, is not the same promise. Fix the missing step before calling it shipped.
