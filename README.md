# RiTa 2.0
Ongoing development of the RiTa library version 2.x (Java)

For JavaScript, see [this repo](https://github.com/dhowe/rita2js) and/or [try the beta](https://github.com/dhowe/rita2js#installation)!

### Building
```
$ git clone https://github.com/dhowe/rita2.git
$ cd rita2
$ mvn install -D skipTests  # should see "BUILD SUCCESS"
```
The project requires a minimum version of Java 8 and Maven 3.6 to build.

### Eclipse
1. Do steps above under **Building**
2. In eclipse, File->Import->Maven->Existing Maven Projects and select your 'rita2' folder
3. Right-click on project, and select 'Run-as' -> 'Maven install' or 'JUnit tests'
