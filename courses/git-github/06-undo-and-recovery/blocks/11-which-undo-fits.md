---
type: Question
title: Which undo fits?
---

You commit a fix, push it, and then discover it breaks the build. Which undo do you use?

`git revert <commit>`. The commit is already shared, so rewriting it with reset would make your history diverge from anyone who pulled it. Revert adds a new commit that reverses the change, and you push that. The original commit stays in history, which is the honest record of what happened.

If the commit were still local and unpushed, `git reset` could move the branch instead. The question is not "which command undoes a commit?" but "who already has this commit?"
