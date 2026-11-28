---
type: Example
title: From branch to pull request
---

Start from an up-to-date `main` and create a branch:

```bash
git switch main
git pull --ff-only
git switch -c add-greeting
```

Make the change and commit it:

```bash
echo "Hello, world" > greeting.txt
git add greeting.txt
git commit -m "Add greeting"
```

Push the branch and open the pull request:

```bash
git push -u origin add-greeting
gh pr create --base main --head add-greeting --title "Add greeting" --body "Adds a greeting file and a short test."
```

`gh` prints the pull request URL:

```text
https://github.com/team/recipes/pull/42
```

The branch stays on the remote; the pull request tracks it. Pushing more commits to `add-greeting` updates the pull request automatically. There is no separate "update the PR" command for code changes.
