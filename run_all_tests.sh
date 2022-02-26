javac -Xlint:rawtypes *.java
java Test1 | grep failed;
java Test2 | grep failed;
java Test3 | grep failed;
java Test4 | grep failed;
java Test5 | grep failed;
java Test6 | grep failed;
java -jar ~cs2030s/bin/checkstyle.jar -c ~cs2030s/bin/cs2030_checks.xml *.java;
