---
type: Explain
title: What a version control system records
---

A version control system answers a narrow but powerful question: what did the project look like at each recorded point, and how did it get here?

For each version, it records two things. The first is the content: the state of every tracked file. The second is metadata: who made the version, when, what message describes it, and which version came before it. Git calls a recorded version a commit.

The parent link is what turns separate versions into a history. A commit that points to its parent, which points to its parent, forms a chain back to the first commit. That chain is the project's history.

The content and the metadata serve different purposes. Content lets you restore a file or compare two states. Metadata lets you search for a change, attribute it, and understand intent. A version without a message is still restorable; a version without content is not.

Because the history is built from the recorded versions themselves, it does not drift out of date the way a separate changelog can. If a change was never recorded, though, no tool can recover it. Version control records what you commit.
