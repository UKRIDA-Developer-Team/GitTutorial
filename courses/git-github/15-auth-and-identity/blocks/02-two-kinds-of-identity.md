---
type: Explain
title: Two kinds of identity
---

A commit carries an author name and email. Git writes them from `user.name` and `user.email` when you commit. Nothing verifies them: anyone can set any value. GitHub may mark a commit as unverified when its author email is not associated with the account, but the commit still exists.

Authentication is separate. It is the credential Git or `gh` presents to a remote to prove which account is acting. A token, an SSH key, or a credential helper supplies that proof. Authentication answers "who is this?"; authorization answers "what may this account do?"

Changing `user.email` does not change your GitHub login. Running `gh auth login` does not set the author of your commits. A working setup needs both: an identity for new commits and a credential for the remote.

Git reads configuration in layers. A repository-local value overrides the global value, which overrides the system value. That lets one machine use a work email in a work repository and a personal email everywhere else.
