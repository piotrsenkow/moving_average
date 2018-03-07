

#Moving Average Scala 
**by Piotr Senkow**

##How do I install and run this?

* Clone the repository and make sure to have Scala and SBT installed.  
* Navigate to ~/moving-avg$. 
* Run command: _for i in {1..20}; do echo $i; done | sbt "run 1 10"_ if you want to loop values 1 through 20 into the standard input and have window sizes 1 and 10.
* You can run any command that will create standard input for the program such as:_yes 1 | head -20 | sbt "run 1 8 15"_ which inputs the value "1" 20 times with window sizes 1 8 and 15. 

##How does this program work?

This program reads a continuous stream of numbers, separated by whitespaces, from the standard input. For each number read, the program produces the following output on a single line:

* the number read
* how many numbers read so far
* for each window size indicated, the following moving stats for this window size:
 -min
 -average (mean)
 -max
If fewer numbers than the window size have been read, the stats are undefined, and your program will print a question mark for each such stat.

##Example:
_for i in {1..20}; do echo $i; done | sbt "run 1 10"_ produces:
1 1 1.0 1.0 1.0 ? ? ?
2 2 2.0 2.0 2.0 ? ? ?
3 3 3.0 3.0 3.0 ? ? ?
4 4 4.0 4.0 4.0 ? ? ?
5 5 5.0 5.0 5.0 ? ? ?
6 6 6.0 6.0 6.0 ? ? ?
7 7 7.0 7.0 7.0 ? ? ?
8 8 8.0 8.0 8.0 ? ? ?
9 9 9.0 9.0 9.0 ? ? ?
10 10 10.0 10.0 10.0 1.0 5.5 10.0
11 11 11.0 11.0 11.0 2.0 6.5 11.0
12 12 12.0 12.0 12.0 3.0 7.5 12.0


