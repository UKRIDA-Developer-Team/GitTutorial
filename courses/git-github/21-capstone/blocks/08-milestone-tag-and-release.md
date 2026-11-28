---
type: Example
title: "Milestone 5: tag and release"
---

Sync the merged base branch:

```bash
git switch main
git pull --ff-only
git log -1 --oneline
```

The feature is backward compatible, so the version gets a minor bump:

```bash
git tag -a v1.1.0 -m "Release v1.1.0"
git push origin v1.1.0
```

Publish the release from that tag:

```bash
gh release create v1.1.0 --verify-tag --title "v1.1.0" --generate-notes
gh release view v1.1.0
```

`--verify-tag` makes the command fail if the tag is not already on the remote. That prevents a typo from creating a new tag from the default branch. `--generate-notes` produces a starting point; edit the notes if the generated list omits the user-facing change or an upgrade step.

Verify the tag and the commit:

```bash
git show v1.1.0
```

The tag should point at the squash commit that contains the feature. The release should name the same tag. If they disagree, stop and fix the release before announcing it.

The capstone is now shipped: the issue is closed, the pull request is merged, the tag is pushed, and the release exists.
