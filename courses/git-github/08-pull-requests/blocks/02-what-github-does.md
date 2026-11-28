---
type: Explain
title: What GitHub actually does
---

A pull request is a record in GitHub's database, not an object in your Git repository. It names two branches: the base branch, where the merge would land, and the head branch, which contains the proposed work. Both branches live in repositories GitHub knows about.

GitHub uses those refs to show the diff between the merge base and the head, and to list the commits on the head that are not on the base. It stores the title, description, author, comments, reviews, and check results alongside that comparison. None of that metadata is part of the Git history.

The platform also provides the actions around the merge. It can run CI checks, require approvals, block a merge while checks fail, and perform the merge itself. The merge updates the base branch on GitHub using one of three strategies: a merge commit, a squash, or a rebase. Closing a pull request without merging changes nothing in Git; the branches stay where they were.

That is why a pull request can exist only on a hosting platform. Git has no pull request command, and cloning a repository does not clone its pull requests. The pull request is collaboration built around Git refs.
