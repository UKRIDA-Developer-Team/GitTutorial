---
type: Explain
title: The project
---

The recipe application lets users search recipes by name and ingredient. The feature request is:

> Add a vegetarian filter to recipe search. When the filter is on, results include only recipes marked vegetarian. Existing searches must keep working. Document the option in the README.

The acceptance criteria are concrete:

- The search function accepts a vegetarian option.
- When the option is on, non-vegetarian recipes are excluded.
- When the option is off or omitted, results are unchanged.
- Tests cover both cases.
- The README explains the option.

The change is small enough for one pull request and large enough to need more than one commit. It touches code, tests, and documentation. It has a clear definition of done, which is what makes the issue closable.

You will use the repository's existing test command, `npm test`. If your practice repository uses a different command, substitute it consistently. The Git workflow does not depend on the language.
