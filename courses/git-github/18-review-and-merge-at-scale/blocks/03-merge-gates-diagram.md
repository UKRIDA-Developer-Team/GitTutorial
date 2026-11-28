---
type: Diagram
title: Merge gates
---

![A pull request passes through required review, required checks, and the merge queue before it reaches the protected base branch. A failure at any gate returns the pull request to the author.](../media/blocks/merge-gates/merge-gates.svg)

Each gate answers a different question: did a person approve, did the automated checks pass, and does the change still work on the latest base?
