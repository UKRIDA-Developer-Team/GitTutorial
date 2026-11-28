---
type: Diagram
title: Identity and authentication are separate
---

![A commit carries an author name and email set by git config. A push carries a credential from gh, a token, or an SSH key. GitHub checks the account and its repository permission separately.](../media/blocks/identity-and-authentication/identity-and-authentication.svg)

The commit records who wrote the change. The push proves which account is sending it. GitHub evaluates the account's permission after authentication.
