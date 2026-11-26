---
type: Explain
title: Aliases are shortcuts
---

An alias is a short name for a Git command. For example, this creates `git st` as a shortcut for `git status`:

```bash
git config --global alias.st status
```

Aliases can include options:

```bash
git config --global alias.lg "log --oneline --graph --decorate"
```

An alias does not add new behavior. It only saves typing, and it is stored in your Git configuration rather than in the repository's history. A `--global` alias applies to every repository for your user; a local alias applies to one repository.

Aliases are personal. Do not assume a teammate has the same ones, and do not put an alias in a script that other people will run.
