---
type: Explain
title: Triggers
---

The `on` key lists the events that start a workflow. The common ones are `push`, `pull_request`, `workflow_dispatch`, and `schedule`.

`push` runs when commits are pushed to a matching branch or tag. `pull_request` runs when a pull request is opened, updated, or reopened against a matching base branch. `workflow_dispatch` adds a manual run button and can accept typed inputs. `schedule` runs on a cron expression in UTC.

Filters narrow the event. `branches`, `branches-ignore`, `paths`, and `paths-ignore` decide whether a push or pull request qualifies. A workflow that runs only when files under `src/` change saves runner time, but it can also skip a check that branch protection expects, leaving a pull request stuck.

`pull_request` runs in the context of the fork or branch that opened the pull request. For a fork, the workflow gets a read-only token and no repository secrets. That is deliberate: untrusted code should not be able to read secrets.

`workflow_dispatch` and `schedule` require the workflow to exist on the default branch. A manual run can still target another branch with `--ref`.
