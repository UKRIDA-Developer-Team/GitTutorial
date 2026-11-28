---
type: Explain
title: HTTPS and tokens
---

An HTTPS remote looks like `https://github.com/OWNER/REPO.git`. Git asks for a username and password, but GitHub no longer accepts an account password for Git operations. The password position takes a personal access token (PAT), or a credential helper supplies one for you.

A classic PAT has scopes such as `repo`, `read:org`, and `gist`. A fine-grained PAT is limited to selected repositories and permissions and usually has an expiry. Use the narrowest token that works, and give it an expiry.

Typing a token for every push is impractical. A credential helper stores it in the operating system's keychain, or in a protected file. `gh auth setup-git` configures Git to use `gh` as the helper for authenticated GitHub hosts, so the token that `gh` already stores is reused.

A token in a remote URL, such as `https://TOKEN@github.com/...`, is visible in shell history, process listings, and error output. Keep the token out of the URL and let the helper supply it.

HTTPS works through restrictive networks that block SSH, and it is easy to proxy. The cost is that a token is a bearer secret: anyone who copies it can act as you until it expires or is revoked.
