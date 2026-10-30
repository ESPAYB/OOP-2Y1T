# CampusConnect_TSA1

A five-request console prototype. Open this folder as a **Maven project** in NetBeans with a JDK selected. Run `CampusConnectApp` as the main class. For a clean build, choose **Run > Clean and Build Project**; then choose **Run > Run Project**. The project targets Java 8 syntax and uses no external dependencies. Enter the lines in `tests/mixed_input.txt` in order, or provide them as standard input from your IDE or terminal. Prompts may appear together when using redirected input.

From a command line with a JDK and Maven installed:

```sh
mvn clean package
mvn exec:java -Dexec.mainClass=CampusConnectApp < tests/mixed_input.txt
```

If Maven's exec plugin is not available, run the class from NetBeans. The Java source is `src/main/java/CampusConnectApp.java`. `javac` compiles `.java` source into `.class` bytecode; the JVM executes that bytecode to produce console output. The JDK supplies `javac`, the Java runtime and development tools. The JRE supplies the runtime libraries and JVM needed to run compiled code; an IDE helps edit, build, run, and debug the program.

## Design and data flow

One `Scanner` reads complete lines so an invalid number does not leave unread input. Text fields are trimmed; category input is converted to uppercase and checked against four allowed values. Invalid required fields, categories, and priorities re-prompt their own field. A request is accepted only after all five fields validate. The loop indexes six parallel arrays, keeping the ID, name, category, priority, concern, and calculated days together at the same index. The estimate switch assigns base working days; priority 5 saves one day when the base exceeds one. These are duration estimates, not calendar dates. After each accepted request the program prints a ticket. The summary counts categories, sums estimates, and keeps the **first** ticket when priorities tie.

`REQUEST_LIMIT`, `MIN_PRIORITY`, `MAX_PRIORITY`, and `MIN_DAYS` are named constants. IDs are `String` values to preserve leading zeroes or letters. Priority and day counts use `int`; the average uses `double` to retain fractions. `readRequiredText`, `readCategory`, and `readPriority` each own one validation loop. `validateCategory` returns a boolean; `estimateDays` returns an integer; `printTicket` and `printSummary` take their data through parameters. Priority validation checks a single character from `1` through `5`, then subtracts `'0'` to obtain the number. A missing input stream (end of file) is outside ordinary user mistakes; provide all five requests for a complete run.

This milestone uses procedural Java code inside the required `CampusConnectApp` class. There are no student-defined objects, constructors, inheritance, interfaces, or collections. Java still requires a class for `main`, and `Scanner`/`String` are standard input and text types.

## Evidence to capture in NetBeans

1. Open the project and choose **Clean and Build Project**. Save the NetBeans Output window showing `BUILD SUCCESS` with the project name and date.
2. Run the project with `tests/mixed_input.txt`, saving the console output or a screenshot that shows the fifth ticket and summary. Compare it to `tests/expected_output.txt` (terminal prompts may be laid out differently for interactive entry).
3. Copy the observed results into `TESTING.md`, replacing each `Pending IDE run` entry. Keep the build log/screenshot with the project for submission.

This environment has no working JDK compiler or NetBeans, so a successful clean build, runtime output, and screenshot are **not claimed** here. The submitted evidence must come from a real NetBeans or JDeveloper session.

## Continuity and AI disclosure

No earlier approved CampusConnect milestone was supplied in this workspace; this folder is an initial version built from the assignment brief. Before changing an earlier instructor-approved copy, make a separate backup of that copy and compare its decisions with this project. Preserve this project, `tests/mixed_input.txt`, `tests/expected_output.txt`, `TESTING.md`, and the IDE output for the next assessment.

AI assistance: An AI assistant drafted this source, documentation, and predicted test output from the requirements. The student must inspect the code, run it in NetBeans or JDeveloper, verify the output, and retain the assignment prompt and this disclosure in any AI-use log required by the instructor.
