# Time management app

The app allows the user to log the amount of time spent on certain tasks. 


## Documentation

[Requirement specification](https://github.com/riiraty/ot-harjoitustyo/blob/master/dokumentointi/requirement_specification.md)

[Architectural description](https://github.com/riiraty/ot-harjoitustyo/blob/master/dokumentointi/architecture.md)

[Work time log](https://github.com/riiraty/ot-harjoitustyo/blob/master/dokumentointi/work_time_log.md)


## Terminal commands

Older Java version (8) is required to run the commands.


### Testing

Tests can be run with a command

```
mvn test
```

Test coverage raport can be created with a command 

```
mvn jacoco:report
```

Other option is to run tests through Netbeans by right clicking the project, then choosing Run Maven>testcoverage

The raport can be viewed by opening a file _target/site/jacoco/index.html_ with a browser


### Generating the executable jar 

Command

```
mvn package
```

generates in to the directory _target_ executable jar-file _TimeManagementApp-1.0-SNAPSHOT.jar_


### Checkstyle

Checks specified in file [checkstyle.xml](https://github.com/riiraty/ot-harjoitustyo/blob/master/checkstyle.xml) are run with a command

```
 mvn jxr:jxr checkstyle:checkstyle
```

Possible alerts of errors can be viewed by opening a file _target/site/checkstyle.html_ with a browser

