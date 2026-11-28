---
type: Example
title: From issue to merged fix
---

Open an issue:

```bash
gh issue create --title "Install command names the wrong package" --body "The README says to install recipes-cli, but the published package is recipe-cli. Steps: follow the install section. Expected: the command works. Actual: package not found."
```

Suppose the issue is number 42. Create a linked branch and check it out:

```bash
gh issue develop 42 --name fix-install-command --base main --checkout
```

Make the change and commit it:

```bash
# edit README.md
git add README.md
git commit -m "Fix install command package name"
```

Push the branch and open a pull request that closes the issue:

```bash
git push -u origin fix-install-command
gh pr create --base main --head fix-install-command --title "Fix install command package name" --body "Closes #42"
```

After review and checks pass, merge:

```bash
gh pr merge --squash --delete-branch
```

The merge closes issue 42 because the pull request body contains `Closes #42`. The issue timeline records the pull request and the merge. The branch can be deleted; the commit remains on `main`.
