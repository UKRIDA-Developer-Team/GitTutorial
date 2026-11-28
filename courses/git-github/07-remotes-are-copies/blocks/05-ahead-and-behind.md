---
type: Diagram
title: Ahead and behind
---

![A commit graph where main and origin/main share three commits, then diverge. main has one commit the remote does not have, marked ahead 1. origin/main has one commit the local branch does not have, marked behind 1.](../media/blocks/ahead-and-behind/ahead-and-behind.svg)

Ahead counts commits on your branch that the remote lacks. Behind counts commits on the remote that your branch lacks. Fetch updates `origin/main`; it does not move your `main`.
