---
type: Example
title: A remote round trip
---

Clone a repository and make a change:

```bash
git clone https://example.com/team/recipes.git
cd recipes
echo "Tomato soup" > soup.md
git add soup.md
git commit -m "Add soup recipe"
git push
```

A teammate pushes another commit to the same branch. Your next fetch downloads it:

```bash
git fetch
```

Inspect what arrived before integrating:

```bash
git log --oneline HEAD..origin/main
git diff HEAD origin/main
```

`HEAD..origin/main` lists commits reachable from `origin/main` but not from `HEAD`. The diff shows the combined change. If you have no local commits of your own, integrate with a fast-forward:

```bash
git pull --ff-only
```

If you do have local commits, `--ff-only` fails because the branches have diverged. You then choose merge or rebase, as covered with history operations. Fetch first, look, then integrate; that order keeps the decision yours.

`git status` after the fetch reports how far ahead or behind you are, and `git branch -vv` shows the same counts next to the branch name.
