---
type: Explain
title: Dependabot
---

Dependabot watches dependency manifests and lockfiles for updates and known vulnerabilities. A security update opens a pull request when an advisory affects a dependency. A version update opens a pull request on a schedule when a newer version is available.

Configuration lives in `.github/dependabot.yml`:

```yaml
version: 2
updates:
  - package-ecosystem: "npm"
    directory: "/"
    schedule:
      interval: "weekly"
    open-pull-requests-limit: 5
```

Each ecosystem has its own name, such as `npm`, `pip`, `bundler`, `cargo`, or `github-actions`. The directory is relative to the repository root. A monorepo can declare several update entries for different directories.

Dependabot pull requests are ordinary pull requests. They run CI, need review, and merge through the same gates. Read the release notes and the diff, especially for a major version. A green test suite does not prove that a breaking dependency change is safe.

Grouping related updates reduces noise. Auto-merge can be reasonable for patch updates with strong tests; it is a poor default for major updates. Dependabot pull requests from the bot have a read-only token and no repository secrets by default, so a workflow that needs secrets may fail until a maintainer handles it.

There is no `gh dependabot` command. The configuration is a file, and the alerts and security settings are platform features.
