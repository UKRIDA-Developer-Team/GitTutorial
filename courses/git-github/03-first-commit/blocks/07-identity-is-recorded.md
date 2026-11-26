---
type: Explain
title: Your identity is recorded
---

Git records the configured name and email in every commit you create. That metadata is part of the commit hash and is published when you push. Use an address you are comfortable making public.

Hosting platforms often provide a no-reply address, such as `12345678+username@users.noreply.github.com` for GitHub. Configure that address if you want to keep your real one private. A pseudonymous name is also acceptable for public work; the email is the part that usually identifies an account.

Configuration has three common scopes: system, global for your user, and local for one repository. A more specific scope overrides a broader one. `git config --show-origin --get user.email` tells you which file supplied the value.

Set the identity before your first commit. Changing it later does not rewrite existing commits; it only affects new ones.
