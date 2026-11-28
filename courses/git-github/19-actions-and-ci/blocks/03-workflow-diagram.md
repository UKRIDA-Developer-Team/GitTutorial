---
type: Diagram
title: From event to check
---

![A push, pull request, or manual dispatch triggers a workflow file. The workflow runs a job on a runner, the job runs steps, and the result becomes a check on the commit or pull request.](../media/blocks/workflow-diagram/workflow-diagram.svg)

The event selects the workflow. The workflow selects the runner and steps. The result reports back to the Git object that triggered it.
