---
type: Commands
title: Tag and publish
---

| Command | What it does |
| --- | --- |
| `git tag -a v1.4.0 -m "Release v1.4.0"` | Create an annotated tag on the current commit |
| `git push origin v1.4.0` | Push one tag to the remote |
| `git tag --list` | List local tags |
| `gh release create v1.4.0 --title "v1.4.0" --notes "..."` | Publish a release for the tag |
| `gh release create v1.4.0 --generate-notes` | Generate notes from merged pull requests |
| `gh release create v1.4.0 --draft` | Create the release without publishing it |
| `gh release create v1.4.0 --prerelease` | Mark the release as a pre-release |
| `gh release list` | List releases |
| `gh release view v1.4.0` | Show a release |
| `gh release download v1.4.0` | Download its assets |

`git tag -a` records a message and a tagger. Use the commit that passed CI on the branch you intend to release, not a later commit that happens to be on `main`.

Push the tag explicitly. `git push` pushes branches, not tags by default. `git push --tags` pushes every local tag, including ones you may not intend to publish; naming the tag is safer.

`gh release create` accepts a tag that already exists on the remote. If the tag does not exist, it can create one from the default branch; use `--verify-tag` when you want the command to fail instead of creating a tag silently.

`--draft` is useful for preparing notes and assets before users see them. `--prerelease` marks a release that is not yet the stable version. `--generate-notes` uses GitHub's release notes API, which groups merged pull requests; review and edit the result before publishing.
