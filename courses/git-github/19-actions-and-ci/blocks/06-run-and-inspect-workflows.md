---
type: Commands
title: Run and inspect workflows
---

| Command | What it does |
| --- | --- |
| `gh workflow list` | List workflows in the repository |
| `gh workflow view ci.yml` | Show a workflow and its recent runs |
| `gh workflow run ci.yml` | Manually start a workflow |
| `gh workflow run ci.yml --ref feature` | Run the workflow on another branch |
| `gh run list` | List recent workflow runs |
| `gh run view` | Show a run's jobs and steps |
| `gh run view --log-failed` | Show logs for failed steps |
| `gh run watch` | Follow a running workflow |
| `gh run rerun --failed` | Rerun only the failed jobs |
| `gh run download` | Download artifacts from a run |

`gh run list` shows the workflow, branch, event, status, and conclusion. `gh run view` drills into jobs and steps; `--log-failed` is usually the fastest way to see the error without reading a successful job's entire log.

`gh run rerun --failed` is for a transient failure, such as a network timeout. It is not a fix for a deterministic failure. If the same step fails again, read the log and reproduce the condition instead of rerunning until it passes.

`gh workflow run` needs `workflow_dispatch` in the workflow file. Without that trigger, the command has nothing to dispatch.
