---
type: Explain
title: A project without history
---

Imagine you are writing a report in a folder called `reports`. On Monday you save `report.docx`. On Tuesday you rewrite the introduction, save again, and the Monday version is gone. On Wednesday a colleague asks for the paragraph you deleted. You have no copy, no record of when it disappeared, and no way to tell which sentences changed.

This is the everyday problem version control solves. Without a record, a project has only its current state. The current state cannot answer:

- What did this file look like last week?
- Who removed the budget table, and when?
- Which of `report-final.docx` and `report-final-v2.docx` is current?
- What exactly changed between the version sent to the client and the version we have now?

File copies appear to preserve history, but they preserve copies, not history. A copy records what a file looked like, not why it changed, who changed it, or what else changed at the same time. As more people work and more files change, the copies multiply and the answers get harder.

A version control system replaces the pile of copies with one history. Each recorded version is a snapshot with a message and an author, and the tool can compare any two versions.
