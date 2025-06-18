# Gherkin Executor for Java



The full documentation is at [GitHub - atdd-bdd/GherkinExecutorBase: This is the base for Gherkin Executor containing Documentation and Examples](https://github.com/atdd-bdd/GherkinExecutorBase)

You can see an example of a featurex file at:  

 https://github.com/atdd-bdd/GherkinExecutorForJava/blob/main/src/test/java/examples.featurex

The generated code, as well as the altered glue file are in this directory:: [GherkinExecutorForJava/src/test/java/gherkinexecutor/Feature_Examples at main · atdd-bdd/GherkinExecutorForJava · GitHub](https://github.com/atdd-bdd/GherkinExecutorForJava/tree/main/src/test/java/gherkinexecutor/Feature_Examples)

To install a Gherkin Executor for your project:

- Create a new project (or use existing one)

- Copy `Translate`into the project structure (e.g.` src/main/java/gherkinexecutor`)

- Create a `src/test/java `directory if it does not already exist
  
  - Or alter `public static final String featureSubDirectory = "src/test/java/";`

- Copy` starting.featurex` into that`directory

- Alter ``public static final String testFramework = "JUnit5"`;to whatever test framework you are using

- Execute` Translate.java` with `starting.featurex` as an argument.

You should see a new directory` test/java/gherkinexecutor/Feature_Starting`

In that directory, there are four files.

- The tests are in` Feature_Starting.java  `

- You need to rename` Feature_Starting_glue.tmpl` to` Feature_Starting_glue.java`.     This is the file you will alter to call the production code.  

- Run the tests in `Feature_Starting.java`

- They should all fail.   Create a temperature convertor and alter the glue code to call it. 



## Trying the Whole Repository

You can try the application out as a whole or just start using it (as above)   

#### Test Framework:

Once you have downloaded the files for either IDE, if you are using a test framework other than` JUnit5`, you will need to change the following in `Configuration`.  
       public static final String testFramework = "JUnit5"; // Could be "JUnit4" or "TestNG"  

##### For IntelliJ:

- Clone the `GherkinExecutorForJava` project from https://github.com/atdd-bdd/GherkinExecutorForJava.   

- You will see only one file `Translate.java` in the gherkinexecutor package.   
  This file contains all the classes required for translation.   

- Run the `Feature_Examples`.java file in the `gherkinexecutor.Feature_Eaamples` package.  You should see that it successfully runs  
  four tests, two of which are listed above. Examine `Feature_Examples_glue.java` and see how the glue code calls the production code.      

- You can also run `Feature_tic_tac_toe`in the `gherkinexecutor.Feature_Tic_Tac_Toe`.  

- If you are able to clone, just copy the `Translate.java` and` simple_test.featurex`  files into your project.  

##### For Eclipse

* Create a new project.     

* Download the `GherkinExecutorForJavaForEclipse.zip file from https://github.com/atdd-bdd/GherkinExecutorForJava.  

* Unzip this file into the project you created.     

* You will see only one file `Translate.java` in the `main.java.gherkinexecutor` package. This file contains all the classes required for translation.  

* Run the `Feature_Examples`.java file in the `test.java.gherkinexecutor.Feature_Eaamples` package. You should see that it successfully runs four tests, two of which are listed above. Examine `Feature_Examples_glue.java` and see how the glue code calls the production code.  

* You can also run `Feature_tic_tac_toe`in the `test.java. gherkinexecutor.Feature_Tic_Tac_Toe`.  

* There are slight differences between the `Translate.java for IntelliJ `and for` Eclipse`.  (The package names need to include the directory and there is a difference in escape characters for the JSON methods).    

### Your Project

OK, the proof is in the pudding.   Let's apply Gherkin Executor to your  problem.   

#### Setup

First, the setup.  

- Create a package "gherkinexecutor" in your project test directory.   

- Copy the `Translate` file from the GherkinExecutor source to your project.     
  If you wish, you could move the Configuration class into a different file in the gherkinexecutor package.    

- Copy one of the files (say simple_test.featurex) into the test directory.    
  It is specified by the Configuration value.  If you want to use a different directory, then change this value.  

- Make sure the Java version is at least 15.     

```
public static final String featureSubDirectory = "src/test/java/";  
```

GherkinExecutor can search for all feature files in the directory tree starting with:  

```
       public static final String startingFeatureDirectory = featureSubDirectory;        // where the directory tree of features is to be found.  
```

So, the feature file should be translated.   However, you can also put the name as a program argument to the run  
(or add it to the file list in Configuration, e.g.)  

```  

```
