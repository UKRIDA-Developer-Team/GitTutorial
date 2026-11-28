---
type: Question
title: Why does gh work but git push fail?
---

`gh pr list` shows pull requests, but `git push` fails:

```text
remote: Permission to team/recipes.git denied to olduser.
fatal: unable to access 'https://github.com/team/recipes.git/': The requested URL returned error: 403
```

Why can one tool reach GitHub while the other cannot?

`gh` and Git can use different credentials. `gh` reads its own stored token. Git reads the credential helper configured for the remote's protocol, which may still hold a token for an old account. The remote may also use HTTPS while you tested SSH, or point at a fork where the current account has no write access.

Check each layer:

```bash
gh auth status
git remote -v
git config --show-origin --get-all credential.helper
ssh -T git@github.com
```

A `401` means the credential was rejected. A `403` means the account authenticated but is not allowed to do that action. Fix the layer that is wrong: run `gh auth setup-git` to connect Git to `gh`, switch to the correct account, update the remote URL, or add the SSH key. Then retry the push.
