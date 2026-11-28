---
type: Commands
title: Authenticate with gh
---

| Command | What it does |
| --- | --- |
| `gh auth login` | Sign in to a GitHub host and store a credential |
| `gh auth status` | Show the authenticated accounts and token state |
| `gh auth setup-git` | Configure Git to use `gh` as its credential helper |
| `gh auth switch --user USER` | Change the active account for a host |
| `gh auth refresh -s repo` | Add a scope to the current credential |
| `gh auth logout` | Remove stored credentials for a host |

`gh auth login` asks for the host, the preferred Git protocol, and an authentication method. The browser flow stores a token in the system credential store when one is available. Choosing SSH can create or upload a key instead.

`gh auth setup-git` is the bridge between the two tools. It tells Git to ask `gh` for credentials on authenticated hosts, so `git push` and `gh pr create` use the same account. Run it after login if Git still prompts for a password.

`gh auth switch` changes the account used by `gh`. It does not rewrite your commit identity and it does not change the remote URL. Check `gh auth status` after switching, and confirm that the repository's remote points at the account or organization you expect.
