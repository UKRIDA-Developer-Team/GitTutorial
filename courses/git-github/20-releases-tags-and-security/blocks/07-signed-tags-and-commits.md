---
type: Explain
title: Signed tags and commits
---

A signature is cryptographic proof that the person holding a private key created or approved an object. Git can sign tags and commits with GPG or with an SSH key. Signing is not encryption: the commit and its diff remain visible.

A signed annotated tag signs the tag object, which points at a commit. A signed commit signs that commit. Signing a tag does not automatically sign every commit in the history, and signing one commit does not sign the tag that points at it.

Verify locally with `git verify-tag`, `git verify-commit`, or `git log --show-signature`. GitHub shows a `Verified` badge when it can validate the signature against a key associated with the account. The badge means GitHub recognizes the signer; it does not mean the code is correct or safe.

Provenance is strongest when the release tag and the commits it contains are signed, and when branch protection requires signed commits. A signature on a tag that points at an unsigned history proves less than it appears to.

Keep the private key offline or protected by a passphrase. A signature made with a stolen key is still a valid signature.
