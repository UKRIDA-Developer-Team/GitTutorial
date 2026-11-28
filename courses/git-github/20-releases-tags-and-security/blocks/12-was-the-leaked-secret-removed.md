---
type: Question
title: Is the leaked secret safe after deletion?
---

A token was committed in `.env`, then deleted in the next commit and pushed. Is the secret safe now?

No. Git keeps the earlier commit, and the token is still in the repository's history. Anyone who cloned or forked the repository may have it. It may also appear in CI logs, caches, release assets, or a search index.

Revoke the token first. Rotating it makes the exposed value useless, even if the old value remains in history. Then remove the secret from the history if the exposure requires it, force-push the rewritten branches with coordination, and ask collaborators to re-clone or reset. Forks and caches may still hold the old object, which is another reason revocation comes first.

Prevent the next leak with secret scanning, push protection, and a pre-commit check that rejects credentials. Do not rely on deleting the file in a later commit. Git is designed to preserve history, including the history of mistakes.
