---
type: Explain
title: From file copies to distributed history
---

Version control did not begin with Git. It evolved through several generations, each shaped by the way teams worked.

**Local tools.** The first systems, such as SCCS in the 1970s and RCS in the 1980s, tracked one file at a time on one machine. They were useful for a single developer, but they had no shared project history and no support for a team.

**Centralized systems.** CVS in the 1990s and Subversion in the 2000s put one history on a server. Each developer checked out files, edited them, and committed back. This made collaboration possible. It also made the server a single point of failure and required a network connection for most operations. Branching was often slow, and merging was painful.

**Distributed systems.** Git and Mercurial appeared in the mid-2000s. Each clone contains the full history, so committing, comparing, and branching happen locally. A server is still useful for sharing and backup, but it is no longer the only copy of the history. This is the model Git uses.

**Hosted platforms.** GitHub, GitLab, and Bitbucket added accounts, pull requests, issues, and automation on top of Git repositories. They made collaboration around Git convenient, and they are a major reason Git spread beyond early adopters.

Each generation solved a limit of the previous one. Centralized systems made shared history possible; distributed systems made that history local and fast; hosting platforms made collaboration visible.
