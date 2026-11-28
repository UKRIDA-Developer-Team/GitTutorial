This chapter explains GitHub Actions as a CI system: workflow files in the repository, events that start them, jobs that run on GitHub's runners, and checks that report back to a commit or pull request. It uses the GitHub CLI, `gh`, to run and inspect workflows. GitHub's website shows the same runs, and other formats of this course may show the web interface.

The examples assume a repository with a Node.js project and a working `gh` login. The YAML is content in the repository, not a Git command. The Git sandbox does not execute workflows.
