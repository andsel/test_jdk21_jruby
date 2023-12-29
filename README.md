## Expose the problem from Gradle run


Launching the `boom` task from a shell where the JVM is 21:

```
./gradlew boom
```

trigger the following error:
```
andrea:test_jdk21_jruby (main) % ./gradlew boom

> Task :boom FAILED
DBG>> before crashing

FAILURE: Build failed with an exception.

* Where:
Build file '/private/tmp/test_jdk21_jruby/build.gradle' line: 42

* What went wrong:
Execution failed for task ':boom'.
> (ArgumentError) wrong number of arguments (given 1, expected 0)

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

BUILD FAILED in 370ms
1 actionable task: 1 executed
andrea:test_jdk21_jruby (main) %
```

However from the same shell launching the Java application that runs the JRuby intepreter, in exact same way that it does from Gradle task, but this time with:
```
./gradlew run
```

Terminates correctly.

The problem seems to reside in 
```
list.map
```
when using JDK21 and launching the interpreter from Gradle task.