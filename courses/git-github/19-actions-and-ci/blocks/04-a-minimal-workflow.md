---
type: Example
title: A minimal workflow
---

This workflow runs the test suite on pushes to `main` and on every pull request:

```yaml
name: CI

on:
  push:
    branches: [main]
  pull_request:

permissions:
  contents: read

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-node@v4
        with:
          node-version: 22
          cache: npm
      - run: npm ci
      - run: npm test
```

`actions/checkout` copies the repository into the runner's workspace. Without it, the job starts in an empty directory. `actions/setup-node` installs the requested Node.js version and can cache the npm download directory.

`npm ci` installs exactly the versions in `package-lock.json`. It fails when the lockfile and `package.json` disagree, which is useful in CI. `npm test` runs the project's test script.

`permissions: contents: read` gives the workflow token only what it needs to read the repository. A workflow that publishes packages or comments on a pull request needs additional permissions, granted deliberately.

The file must be committed on the branch that triggers the event. A workflow added only to a feature branch will not run for events on the default branch until it is merged.
