---
type: Question
title: What comes after Git?
---

Several systems are trying to improve on Git, especially for very large repositories and for workflows built around many small changes.

- [Sapling](https://sapling-scm.com/docs/introduction) is a Git-compatible client developed at Meta. It emphasizes usability and scale, and it can work with existing Git repositories. Its client and server are designed for monorepos with millions of files. The tradeoff is that its workflow and tooling differ from standard Git, and adoption outside Meta is limited.
- [Jujutsu](https://docs.jj-vcs.dev/latest/) is a Git-compatible version control system built around changes rather than commits. It is designed to make editing history and working with branches more fluid. Its model is powerful but unfamiliar, and it is young compared with Git.
- **Scion** is Anthropic's in-house version control system. Anthropic has described migrating its monorepo from Git to Scion, which is built around a central server and is not publicly available. Read [Redesigning source control at Anthropic](https://www.anthropic.com/research/redesigning-source-control) for the design rationale. It is evidence that Git's design has limits at extreme scale, not a tool most teams can adopt today.

These tools show that Git's model is not the end of the story. For most teams and public projects, however, Git remains the shared default, and the alternatives are usually chosen for a specific scale or workflow problem.
