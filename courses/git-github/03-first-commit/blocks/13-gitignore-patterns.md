---
type: Example
title: Reading gitignore patterns
---

Consider this `.gitignore` at the repository root:

```gitignore
# Dependencies and build output
node_modules/
dist/

# Secrets
.env
.env.local

# Logs, but keep the important one
*.log
!important.log

# Editor files anywhere
**/.idea/
```

- `node_modules/` ignores that directory at any depth.
- `dist/` ignores a directory named `dist` at any depth.
- `.env` and `.env.local` ignore those files at any depth.
- `*.log` ignores log files, and `!important.log` re-includes one of them.
- `**/.idea/` matches an `.idea` directory at any depth.

To check which rule applies, run `git check-ignore -v path`. It prints the matching file, line, and pattern. A path that is already tracked is not affected by these rules.

One ordering rule catches people: you cannot re-include a file if its parent directory is excluded. This does not work:

```gitignore
build/
!build/keep.txt
```

Git never looks inside the excluded directory, so the negation has nothing to match. Exclude the directory's contents instead:

```gitignore
build/*
!build/keep.txt
```

Now the directory itself is not excluded, and the negation can re-include the one file.
