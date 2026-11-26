---
type: Question
title: Where does the label move?
---

Suppose `main` points to commit C2 and `feature` points to C1. `HEAD` points to `feature`. You make a new commit, C3.

Which labels move?

Only `feature` moves, from C1 to C3. `HEAD` still points to `feature`, so it follows that branch to C3. `main` stays at C2.

If `HEAD` had pointed directly at C1 instead, the new commit would have no branch label at all. That is the detached state.
