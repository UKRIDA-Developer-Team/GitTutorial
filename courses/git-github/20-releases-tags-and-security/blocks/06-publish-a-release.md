---
type: Example
title: Publish a release
---

Start from the commit that passed CI:

```bash
git switch main
git pull --ff-only
git log -1 --oneline
```

Create an annotated tag and push it:

```bash
git tag -a v1.4.0 -m "Release v1.4.0"
git push origin v1.4.0
```

Create a draft release with generated notes, then review it:

```bash
gh release create v1.4.0 --title "v1.4.0" --generate-notes --draft
gh release view v1.4.0
```

Attach a built binary and its checksum:

```bash
gh release upload v1.4.0 dist/recipes-linux-amd64 dist/recipes-linux-amd64.sha256
```

Publish the draft when the notes and assets are correct:

```bash
gh release edit v1.4.0 --draft=false
```

Verify what users will get:

```bash
gh release download v1.4.0 --pattern "*.sha256"
git show v1.4.0
```

`git show` displays the tag object and the commit it points at. `gh release view` shows the platform record. Both should name the same version and the same commit.
