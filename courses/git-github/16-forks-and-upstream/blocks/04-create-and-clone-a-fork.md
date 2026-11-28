---
type: Commands
title: Create and clone a fork
---

| Command | What it does |
| --- | --- |
| `gh repo fork OWNER/REPO --clone` | Fork a repository and clone your fork |
| `gh repo fork --clone` | Fork and clone the repository for the current directory |
| `gh repo fork OWNER/REPO --org TEAM --clone` | Create the fork under an organization |
| `gh repo fork --remote` | Add a remote for the fork to an existing clone |
| `git remote -v` | Show the fetch and push URLs |

`gh repo fork OWNER/REPO --clone` creates the fork under your account, clones it, and sets up two remotes. `origin` points at your fork; `upstream` points at the source repository. The clone's default branch tracks `origin`, so a push goes to your fork.

If you already cloned the source repository and later create a fork, the remote setup depends on the command and the directory. Run `git remote -v` and confirm which URL each name uses before pushing. A remote name is only a local label; `origin` is not automatically your fork in every repository.

A fork starts with the source's commits and branches, not its issues, pull requests, secrets, or settings. Those belong to the platform objects around the repository, and some are deliberately not copied.
