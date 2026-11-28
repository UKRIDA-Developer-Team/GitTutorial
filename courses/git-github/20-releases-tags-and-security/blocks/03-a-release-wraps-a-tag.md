---
type: Explain
title: A release wraps a tag
---

Chapter 02 established that a tag is a fixed label and that an annotated tag carries a message, tagger, and date. A GitHub Release adds platform metadata around that tag: a title, release notes, optional binary assets, and a draft or pre-release state.

The tag is the Git object. The release is the platform record that points at it. Deleting a release does not delete the tag, and deleting a tag can break the release that points at it. Treat both as published artifacts once users depend on them.

A release can be created from an existing tag or can create the tag at publish time. Creating the tag first is safer: you can inspect the exact commit, sign the tag, push it, and verify it before any release notes or assets are attached.

Release notes are for humans. They should describe what changed, what broke, what was fixed, and how to upgrade. A generated list of commits is a starting point, not a substitute for a migration note.

Assets are files attached to the release, such as binaries, packages, or checksums. They are not part of the Git repository and do not change the tag. If an asset is wrong, replace it deliberately and say so; `--clobber` deletes the old asset first.
