

The initial version of Translator was written for Kotlin.  It was converted to Java and 
other facerts were added. It is currently being converted back 
to Kotlin, Python, and C++.    

# Maintannce 

Multiple testing
Gherkin Full - to see if test and glue file creation remain the same (except for what is expected to change)
	If expected changes are correct, then copy the .tmpl and the test file into the corresponding .exp files 
Run all unit tests (using the directory) with logging and compare against expected - to see if output of tests remain the same (except for what is expected)
	Compare manually the log.txt file to the log.exp file for Gherkin Full 
	If as expected, then copy the log.txt file into log.exp file 
	


github.com/cucumber/gherkin  website 
