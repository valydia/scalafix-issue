# Scalafix rules for scalafix

To reproduce the issue, run:
```
sbt tests/test
```

which outputs:
```text
[info] Compiling 1 Scala source to /Users/valydia/Workspace/valydia/scalafix-issue/rules/target/scala-2.12/classes ...
[info] Done compiling.
Resource[F,Socket[F]] Symbol("fs2/io/udp/package.open().")
<no type> Symbol("fs2/io/udp/package.")

```
