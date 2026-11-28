This chapter uses the GitHub CLI, `gh`, to work with pull requests. GitHub's website can do the same work, but this text covers only the `gh` commands. Other formats of this course may demonstrate the web interface.

`gh` is a separate tool from Git. Git handles commits, branches, and pushes; `gh` talks to GitHub's API for pull requests, reviews, checks, and merges. Install it from [cli.github.com](https://cli.github.com/) and authenticate once:

```bash
gh auth login
```

The examples assume a repository hosted on GitHub with an `origin` remote and a branch you have pushed. Chapter 07 covers remotes and pushing. Pull requests happen on GitHub, not in the Git sandbox, so the hands-on sandbox practices the Git operations rather than the platform workflow.
