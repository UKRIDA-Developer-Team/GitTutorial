---
type: Warning
title: Release and security mistakes
---

- **Moving a published tag.** A version tag should be immutable. If the release is wrong, publish a new patch version instead of deleting and recreating the tag users already downloaded.
- **Assuming a release protects the tag.** Deleting a GitHub Release does not delete its Git tag. Release immutability, when enabled, protects the tag and assets only after publishing.
- **Using `--clobber` casually.** It deletes an existing asset before uploading the replacement. If the upload fails, the old asset is gone.
- **Publishing from a dirty tree.** Tag the commit that passed CI, not a later local state that includes uncommitted or untested changes.
- **Trusting generated notes alone.** Generated notes list changes; they do not explain breaking changes, migrations, or security fixes.
- **Signing with an unregistered key.** A valid signature that GitHub cannot associate with an account does not earn a verified badge.
- **Auto-merging a major dependency update.** Passing tests do not cover every breaking change.
- **Putting secrets in release assets or logs.** A release is public more often than a repository is. Scan the artifact before uploading it.
- **Pushing every local tag.** `git push --tags` publishes tags you may have created for experiments. Push the release tag by name.

A release is a promise. Make the promise small, tested, and reversible by publishing a new version, not by rewriting the old one.
