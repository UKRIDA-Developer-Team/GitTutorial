---
type: Explain
title: Review at scale
---

At scale, review is a queue with limited attention. Small pull requests, clear descriptions, and automated style checks keep that attention on design, correctness, and risk.

A reviewer should read the diff and the tests, not only the green checks. Checks prove what they were written to prove. They do not prove that the change is understandable, that the tests cover the failure mode, or that the design fits the system.

Required approvals can turn into rubber stamps when the same person approves everything. Rotate reviewers, use CODEOWNERS for the areas that need domain knowledge, and ask for a second review when the change is risky. A team that treats approval as a formality has built a queue, not a review.

New commits can invalidate an approval. Many repositories dismiss stale approvals or require review again after a push. If you rewrite a reviewed branch, tell the reviewer what changed and request another look. Do not rely on an approval that was written for different code.

Review latency is a design problem. Open a draft early, keep the description current, and split work that is too large to review in one sitting. A pull request that waits a week for its first comment is usually too big or too vague, not merely unlucky.
