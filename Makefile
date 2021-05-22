test:
	java --enable-preview -jar /lib/Zeus-25.jar test jcb -D -w2 -d1
package:
	mvn clean package
style:
	java --enable-preview -jar /lib/Zeus-25.jar style
progress-bar:
	mvn exec:java -Dexec.mainClass="academy.kovalevskyi.codingbootcamp.week2.day2.ProgressBar" -Dexec.args="15 1"

