# console-drawing

This is a maven based project. Maven should be installed before running the project.

### Dependencies

Note that this program require `Java 8`.

maven - 1.8

junit - 5.3.1

jacoco - 0.8.2 # to generate coverage files

### Compile and Run on command line

After installing maven from the terminal change project root folder directory and use a command of the form

`$ mvn exec:java`

Which will execute the code and gives the chance to enter command.

As long as your compiler supports Java 8 or higher, there should be no errors.

Please find the commands supported from problem statement below.

For running tests and checking the coverage run

`$ mvn test`

After the command is executed successfully, Code Coverage can be found at `${root path}/target/site/jacoco/index.html` after executing the above command.

### Structure of the project:

    .
    ├── ...
    ├── src/main/java/com/drawingprogram/app # main code
    │   ├── App                 # Main class
    │   ├── DrawingHelper       # Helper class which has all the logic
    └── src/test/java/com/drawingprogram/app # unit tests
    │   ├── AppTest
    │   ├── Constants     # Constants used in test cases
    │   ├── DrawingHelperTest
    └── ...

## Problem Statement

**_ The Problem _**

**Description**

You're given the task of writing a simple console version of a drawing program.
At this time, the functionality of the program is quite limited but this might change in the future.
In a nutshell, the program should work as follows:

1.  Create a new canvas
2.  Start drawing on the canvas by issuing various commands
3.  Quit

Command Description
C w h Should create a new canvas of width w and height h.\
L x1 y1 x2 y2 Should create a new line from (x1,y1) to (x2,y2). Currently only
horizontal or vertical lines are supported. Horizontal and vertical lines
will be drawn using the 'x' character.\
R x1 y1 x2 y2 Should create a new rectangle, whose upper left corner is (x1,y1) and
lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
using the 'x' character.\
B x y c Should fill the entire area connected to (x,y) with "colour" c. The
behavior of this is the same as that of the "bucket fill" tool in paint
programs.\
Q Should quit the program.

**Sample I/O**

Below is a sample run of the program. User input is prefixed with enter command:

```text
enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
```

```text
enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------
```

```text
enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------
```

```text
enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------
```

```text
enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------
```

enter command: Q
