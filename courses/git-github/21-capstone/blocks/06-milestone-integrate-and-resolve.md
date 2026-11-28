---
type: Example
title: "Milestone 3: integrate and resolve"
---

`main` moved while the feature was in progress. Fetch it and replay the branch onto the new base:

```bash
git fetch origin
git switch add-vegetarian-filter
git rebase origin/main
```

The README changed on both sides, so the rebase stops:

```text
Auto-merging README.md
CONFLICT (content): Merge conflict in README.md
error: could not apply b7c1e42... Document vegetarian search filter
```

The file contains markers:

```text
<<<<<<< HEAD
## Dietary filters
...
=======
## Vegetarian filter
...
>>>>>>> b7c1e42 (Document vegetarian search filter)
```

During a rebase, `HEAD` is the new base, so the first side is `origin/main`. The second side is your commit being replayed. Keep both sections, remove the marker lines, and stage the file:

```bash
git add README.md
git rebase --continue
```

Run the tests again:

```bash
npm test
```

If the resolution is wrong, `git rebase --abort` returns the branch to its state before the rebase. Do not commit conflict markers, and do not continue until the file makes sense as a whole.
