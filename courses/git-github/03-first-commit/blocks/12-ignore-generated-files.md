---
type: Explain
title: Ignore generated files
---

A `.gitignore` file lists paths that Git should not track. Put it at the repository root, or in a subfolder for patterns that apply only there.

```gitignore
node_modules/
dist/
.env
*.log
```

Patterns are interpreted relative to the `.gitignore` file's folder. A pattern without a slash also matches at any depth. A trailing slash matches directories only. `*` matches within one path segment, `**` matches across segments, and a leading `!` re-includes a path that an earlier rule excluded.

These entries keep dependency folders, build output, secrets, and logs out of commits. Commit the `.gitignore` file itself so everyone working on the project gets the same rules.

Ignoring a path does not remove a file that Git already tracks. If a file was committed before you added it to `.gitignore`, you must untrack it before the ignore rule takes effect. Also keep a safe example file such as `.env.example` when a project needs to document required settings.

Two other ignore files exist. `.git/info/exclude` holds rules for one repository without committing them, and a global excludes file, configured with `core.excludesFile`, holds rules for all your repositories, such as editor backup files. Use `.gitignore` for rules the whole project should share, and the other two for personal or local rules.
