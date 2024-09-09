#!/bin/bash
# i do not really have main methods anywhere since it's utility/library type of lab. so no running from shell
javac -d ./build/classes/java/main/ ./src/main/java/ru/nsu/*.java 
java -classpath .:build/classes/java/main/ ru.nsu.Main
javadoc -d ./docs -sourcepath ./src/main/java ru.nsu

