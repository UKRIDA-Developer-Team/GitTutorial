---
type: Explain
title: Why Git became the standard
---

Git was created in 2005 by Linus Torvalds to manage the Linux kernel. The kernel project had been using a proprietary tool, BitKeeper, and when that arrangement ended, the project needed a replacement that could handle thousands of contributors and a very large history. Git was built for that scale and released as free software.

Several design choices made it spread:

- **Local operations.** Commits, diffs, and branches work without a network connection, because each clone has the full history. This made Git fast and usable on unreliable connections.
- **Cheap branching and merging.** Creating a branch takes almost no time or space, and merging is a first-class operation rather than an afterthought.
- **Integrity.** Content is addressed by a hash, so corruption and accidental changes are detectable.
- **Open source and portability.** Git runs on every major platform and can be extended and embedded.

Hosting platforms amplified the effect. GitHub launched in 2008 and made it easy to publish a repository, open a pull request, and collaborate. Other platforms followed. Once projects, employers, and open source communities standardized on Git, using it became the path of least resistance.

Git is not the only good version control system, but it is the one most teams can assume. That assumption is a network effect: the tool is valuable partly because other people use it.
