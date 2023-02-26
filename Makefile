run:
	rm ./ija/ija2022/homework1/**/*.class
	rm ./ija/ija2022/homework1/*.class
	javac -cp .:junit-platform-console-standalone-1.6.0.jar ija/ija2022/homework1/Homework1Test.java
	java -cp .:junit-platform-console-standalone-1.6.0.jar org.junit.runner.JUnitCore ija.ija2022.homework1.Homework1Test

clear:
	rm ./ija/ija2022/homework1/**/*.class
	rm ./ija/ija2022/homework1/*.class