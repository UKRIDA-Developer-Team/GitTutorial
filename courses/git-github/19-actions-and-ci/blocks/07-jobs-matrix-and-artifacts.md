---
type: Explain
title: Jobs, matrix, and artifacts
---

Jobs are isolated. Each job gets a fresh runner, so files written by one job are gone unless they are uploaded as an artifact or committed. `needs: build` makes a job wait for another job and lets it consume outputs that were passed deliberately.

A matrix runs the same job with different values:

```yaml
jobs:
  test:
    strategy:
      fail-fast: false
      matrix:
        node: [20, 22]
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-node@v4
        with:
          node-version: ${{ matrix.node }}
      - run: npm ci
      - run: npm test
```

This creates two jobs, one for each Node.js version. `fail-fast: false` lets both finish so you see every failure instead of stopping at the first. A matrix multiplies runner time, so keep the combinations meaningful.

Artifacts are files kept after a job finishes, such as test reports, screenshots, or build output. `actions/upload-artifact` stores them; `actions/download-artifact` retrieves them in another job. An artifact is not a commit and does not change the repository. It expires according to the repository's retention setting.

Caching is different from an artifact. A cache speeds up a later run by reusing dependencies or build output when a key matches. A stale or poisoned cache can make a run fail in a way that a clean run does not, so include the lockfile hash in the key.
