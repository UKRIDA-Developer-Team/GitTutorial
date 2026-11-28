---
type: Example
title: Contribute from a fork
---

Fork and clone the source repository:

```bash
gh repo fork team/recipes --clone
cd recipes
```

Create a branch from the fork's default branch and make the change:

```bash
git switch -c fix-typo
# edit README.md
git add README.md
git commit -m "Fix install command typo"
```

Push the branch to your fork:

```bash
git push -u origin fix-typo
```

Open the pull request against the source repository. Replace `ada` with your GitHub username:

```bash
gh pr create --repo team/recipes --base main --head ada:fix-typo --title "Fix install command typo" --body "Corrects the package name in the install steps."
```

`--repo` selects the upstream repository, `--base` selects its branch, and `--head` names your fork's branch as `USER:BRANCH`. The pull request now compares your fork's branch with upstream's `main`.

Future commits go to the same branch on `origin` and update the pull request automatically. You do not need write access to `team/recipes`; you need permission to read it and a fork you can write to.
