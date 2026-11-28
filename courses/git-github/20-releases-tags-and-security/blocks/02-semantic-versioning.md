---
type: Explain
title: Semantic versioning
---

Semantic versioning uses three numbers: `MAJOR.MINOR.PATCH`. For a library or application with a public interface, increment the major version for an incompatible change, the minor version for a backward-compatible feature, and the patch version for a backward-compatible fix.

A pre-release adds a suffix, such as `2.0.0-rc.1`. Build metadata adds a plus suffix, such as `1.4.0+build.5`. Pre-release versions sort before the final release; build metadata does not change precedence. A leading `v` in a tag, as in `v1.4.0`, is a naming convention, not part of the semantic version.

Before `1.0.0`, the public interface is usually considered unstable, and any release may change it. Say so in the notes rather than pretending the stability guarantee exists.

The version is a promise to users. A patch release should not require code changes to upgrade. A minor release should not remove an API. A major release may break things, but the notes must say what breaks and how to migrate.

Choose the version before you tag. The tag names the commit; the version tells users what to expect from it.
