
# Gherkin Exectuor  

## Summary 
The GherkinExecutor simplifies the creation of test code from a Gherkin feature file. 
It converts scenarios into unit tests.   It is designed to work the same way with any 
implementation language.   For Java, the application is available at 
https://github.com/atdd-bdd/GherkinExecutorForJava.  Versions in other languages are being
created. 

## Inspiration 
This form for expressing shared understanding came from Ward Cunningham's FIT
(Framework for Integrated Testing).  Gherkin came from Aslak Hellesøy.  Running a program
to create code as unit tests from Gojko Adzic.   

## Why Use Gherkin?
Gherkin feature files are readable executable documentation.  If a requirement / story
includes buiness rules, they provide a convenient form to collaborate with non-programmers.   They 
also provide a way to document parts of a domain driven design. 
For a developer they provide an alternative way to specify the values used 
to call a parametrized test method.  The scenarios can be used in user documentation.

For domains which have two-dimensional objects, the tabluar format can be much easier
to comprehend. (See the tic-tac-toe example.)

### introductory Example 
Here are a few introductory examples. You can view the `examples.feature` file in the main test directory 
and the associated files in the gherkinexecutor.Feature_Examples package in the test directory.  
directory The first scenario shows a calculation from Fahrenheit to
Celsius.  When it is translated, three files are created - one is a unit test file, one 
is glue code which is revised to connect to the production code, and the third is 
a data file which declares the classes used to connect the unit test code to the glue code.
The full code is shown later.
```
Scenario: Temperature 
Calculation Convert F to C # ListOfObject TemperatureCalculation 
| F    | C    | Notes       |
| 32   | 0    | Freezing    |
| 212  | 100  | Boiling     |
| -40  | -40  | Below zero  |
```
An Excel-style table is a familiar construct to many non-programmers.
(Ward Cunningham introduced this style with FIT).  So this form is easily understandable.
To add another variation, you simply add another row to the table.  The comments
`# ListOfObject TemperatureComparison` are used to create the unit tests (shown later)

The Triad (Customer, Developer, Tester perspectives) can collaborate on the detailed behavior.  This
separates the production implementation from the representation of the logic and calculations.  For example,
one of the Triad might ask about the result for this calculation:  
```
| F    | C       | Notes                                              |
| 33   | .555    | How many decimal digits or what sort of roundoff?  |
```
The Triad would then discuss what the behavior should be.  Note that
the internal representation of F or C is irrelevant - it could be double, Double, BigInteger, or
something else.   

If your code style is to use Abstract Data Types, you can create a table to show examples of 
allowable values (or all allowed values, in the case of an enum).
```
Scenario: Domain Term ID 
Rule ID must have exactly 5 letters and begin with Q # ListOfObject DomainTermID
| Value   | Valid  | Notes              |
| Q1234   | true   |                    |
| Q123    | false  | Too short          |
| Q12345  | false  | Too long           |
| A1234   | false  | Must begin with Q  |
```
This table could be used in a help file to show examples of valid IDs. 

## Getting Started 
You can try the application out as a whole, or just start using it. 
### The Application 
Download the GherkinExecutorForJava project. You will see only one file `Translate.java` in the gherkinexecutor package. 
This file contains all the classes required for translation.   
Run the Feature_Examples.java file in the gherkinexecutor.Feature_Eaamples package.  You should see that it successfully runs
four tests, two of which are listed above.  You can also run Feature_tic_tac_toe.   
### Your Project 
OK, the proof is in the pudding.   Let's apply GherkinExecutor to your  problem. 
#### Setup 
First, the setup. Create a package "gherkintranslator" in your project.  Copy the Translate file from the GherkinExecutor source to your project.   If you wish, you could move the Configuration class into a different file in the gherkinexecutor package.  
Check to make sure that this value is false.  
```
public static final boolean inTest = false;  // switch to true for development of Translator
```
If it is set true, then a `fail("Need to implement")`statement will not be in the glue files and all tests will pass.
This is used for running tests on GherkinExectuor itself.   
Copy one of the files (say simple_test.feature) into the test directory.  
It is specified by the Configuration value.  If you want to use a different directory, then change this value.
```   
public static final String featureSubDirectory = "src/test/java/";
```

Put the name as an program argument to the run (or add it to the file list in Configuration, e.g.
```
featureFiles.add("simple_test.feature");
```
You may see several other files that are used for testing GherkinExecutor.   You can comment them out, if they 
aren't already.   They are used for testing the application 
#### Run it:
Run Translate and you should see a new package in the test directory, `gherkinexectuor.Feature_Simple_Test`
The name comes from the Feature name in the file, not the name of the feature file. 
in this package, you will see four files.  Rename the file `Feature_Simple_Test_glue.tmpl` 
to `Feature_Simple_Test_glue.java`.   This will be the only time you will do this, 
 as it is this glue file that you will be making changes to (e.g. adding calls to production code and 
making asserts.) 

If you add additional Scenarios that have new steps, you will need to create the step method in the glue code.
You can do this by either by copying the sample code from the ".tmpl" file or by using the IDE to create it.   
(You'll get more template code if you copy it in from ".tmpl") 

Run Simple_Test and you should get a test failure.   The lines in the output should read something like:
```
---  Given_table_is
ATest {anInt = 1 aString = something aDouble = 1.2 } 
ATestInternal {anInt = 1 aString = something aDouble = 1.2 } 
Must implement
``` 
This is printed by the glue code, which you can take out whenever you desire.   
The first line is the method name, the next two lines show the inputs to the glue method. 
A version of the object named in the step (`# ListOfObject TemperatureCalculation`) with all String attributes
is passed to the glue code. A conversion method to an form of the object with attributes given in 
the Data statement (referred to as the internal object) is provided.    

No calls to production code are in this glue code, as the Scenario is completely independent of the code.
 
Congratulations, you're ready to start with your project.

#### Your Project
You need to import your production code into the glue code and possibly the data code.  You can alter the glue code or your can add the 
import in Configuration with: 
```
linesToAddForDataAndGlue.add("import production_package;"); 
```
Now create a feature file and put it into the feature directory.   Let's say you have `Feature My Feature` as the 
first line.  
```  
public static final String featureSubDirectory = "src/test/java/";
```
and thenthe name as an program argument to the run (or add it to the file list in Configuration, e.g.
```
featureFiles.add("my_feature.feature");
```
Run Translate.  You should see a new package in tests. `gherkinexecutor\Feature_My_Feature`  Rename the `.tmpl` file to `.java` and run the test file 
(the one named `Feature_My_Feature`).  You should get a failure for every scenario.  
 Note that fail() is put into each step, so you will continue to get failure for a Scenario 
 until you implement all the steps.   
 
If you don't use any comments on the steps, all data to glue methods will be passed as a `List<List<String>`  

##### A Few Quick Notes 
 
You can use the name of a production class as the second part of Data statement.  
The names of the attributes should match the attributes in the production class. If the attributes have non-primitive
data types, you will need to create an `Import` statement that describes the constructor and the package. 

Do not create a Data statement with the first part being the name of  the you use in production.    
Add a suffic to it, such as In or somehting or you will get a data clash.  
  

## How It Works in Brief

The translator converts a Gherkin feature file into a unit test file.
The unit test file calls glue methods which the developer edits to call the code under 
test. The translator also creates a template for the glue file.  

The Translator is a single file containing all the necessary components. 
To translate a feature file, you supply the feature files you want converted by either adding them 
to a list in the Translator or adding them as program arguments.  

Unlike other implementations of Gherkin,
each feature file is associated with one unit
test file, its glue file, and multiple class file in the same package.   

If you need the same data types in multiple files, you can use the `Include` statement
to add those data types to a feature. For example, `Include "datadefs.txt"`would add whatever
is in that file to the feature file before it is translated.   

## Why Not Use Existing Frameworks? 

I've been using Cucumber, one of the most common applications that uses 
Gherkin for a number of years.  You can have a table after each step.   However you
need to add additional code to use that table as a list of objects.  The method for doing 
so has changed from version to version and has gotten more complex.     

The Translator converts the Gherkin tables into initialized lists. The developer just needs to 
specify the class of the objects that will be in those lists. It does not depend on 
features of a specific languages, such as introspection. 

The initial version of Translator was written for Kotlin.  It was converted to Java and 
other facerts were added. It is currently being converted back 
to Kotlin, Python, and C++.    A feature file written for one language should work
in the other languages.  The only issues would be replacing the Datatype of a field (e.g. Int)
with the appropriate type in another language.  

Since the entire source code is supplied, a developer can alter the translation to
their preferred style.  For example, if methods should not have underscores, 
that can be changed in a single line.  

## How It Differs From Other Frameworks 
The Translator passes data to steps only through tables.  There are no values embbeded in the
the step statement.  The domain term which a value represents is the header of a column
which contains the values.  

The tables can be passed to the glue methods as a list of objects or a list of strings.  

The glue code for each feature resides in the feature package.  There is no regular expression matching. 
The step statement is converted into a glue code function name.   

If you need the same code to execute for multiple glue code methods, you delegate to a common implementation,
just like you would do with production code. 

The Translate file resides in your application code.  The way it works does not change.  If it works for you, 
there is no reason to change it.    If you want additional features (no sure what they might be), then you  decide
when you want to drop in a new version.  If there are any issues, you revert back to the old one using git (or your
source code control framework). 

The tests are unit tests of your test framework.  So the reporting of your framework works as is.  Your customization 
of the glue code is the same as you would do for a regular unit test.   The only difference would be that You
need to save in glue code class variables any values required for communication between separate steps in a scenario. 
 

You can alter Translate if you want more output from the glue code.       

### Keywords 
There are more keywords than in standard Gherkin. You can add additional ones by modifying Translate.  
```
    "Feature" - first non-blank line in a file - gives name of feature               
    "Scenario" - starts a unit test 

    "Given"  - all of these form a step, which is a method in the glue code.  
    "When"
    "Then"
    "And"
    "Star"
    "Arrange"
    "Act"
    "Assert"
    "Rule"   -  this is just a step, not something special as in Cucumber. 
    "Calculation"
	"*"

    "Background" - specifies one or more glue code methods to run at beginning of a scenario 
    "Cleanup" - specifies one of more glue code methods to run at the end of a scenario 
   
    "Data" - describes the attributes of an object
    "Import" - describes the constructor and package for non-primitive attributes 
    "Define" - defines words and their values that can replace the words in tables.  
```
## How It Works in Detail
Here is the example feature file again:
```
Feature: Examples

Scenario: Temperature 
# Business rule , Calculation 
Calculation Convert F to C # ListOfObject TemperatureCalculation 
| F    | C    | Notes       |
| 32   | 0    | Freezing    |
| 212  | 100  | Boiling     |
| -40  | -40  | Below zero  |

Data TemperatureCalculation
| Name   | Default  | DataType  | Notes  |
| F      | 0        | Integer   |        |
| C      | 0        | Integer   |        |
| Notes  |          | String    |        |
```
In the test directory, it is named `examples.feature`.  The words after the keyword 
`Feature` are combined into the name of the feature.  Let's assume that you are using the translator with Java 
(language suffix `.java`) 
The operation is the same, the output code depends on the language. 

To translate this feature file, you can pass it as a parameter to the `Translate` main method.  Alternatively
you can add it to the Configuration list of feature files.   
```
featureFiles.add("examples.feature");
```
A unit test file with the name `Feature_Examples.java` (with language appropriate suffix) 
is created in a package with the name `gherkinexecutor.Feature_Examples` with the same name. 
A another filecalled `Feature_Examples_glue.tmpl` is also created.  This contains templates for the glue 
code that is called 
from `Feature_Examples.java`.  One or two files are created for every `Data` statement. Since DataTypes are 
in this Data statement, a class `TemperatureCalculation` with the attributes as Strings, 
and a class `TemperatureCalculationInternal` are creeated. Some common methods for each class are also included.
   
The single step in the `Scenario` ("Convert F to C ") is denoted as `# ListOfObject TemperatureComparison`.  So 
the test file / glue code parameters use a `List<TemperatureComparison>`

Note that a new glue object is created for each Scenario.   This makes each test independent.   If you need 
to share values between scenarios, create a class variable (e.g. static or companion object).  

### Test File 

The `Feature_Examples.java` example file contains code that looks like:
```
    @Test
    void test_Scenario_Temperature(){
         Feature_Examples_glue feature_Examples_glue_object = new Feature_Examples_glue();

        List<TemperatureCalculation> objectList1 = List.of(
             new TemperatureCalculation.Builder()
                .f("32")
                .c("0")
                .notes("Freezing")
                .build()
        // plus two more 
            );
        feature_Examples_glue_object.Calculation_Convert_F_to_C(objectList1);
        }
```
### Glue File 
The `Feature_Examples_glue.tmpl` file has the following in it. 
```
    void Calculation_Convert_F_to_C(List<TemperatureCalculation> values ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        for (TemperatureCalculation value : values){
           System.out.println(value);
                try {
                TemperatureCalculationInternal i = value.toTemperatureCalculationInternal();
                  System.out.println(i);
                    }
                catch(Exception e){
                    System.err.println("Argument Error " + value.toString() + TemperatureCalculationInternal.toDataTypeString());
                }
             }
        fail("Must implement");
    }
```
Note that this loop catches an Exception.  It's possible that the values
in the table are not valid for the types for the field.   For example, 
if `a` is in the table for a field with datatype `int`, then an exception is thrown and caught by 
this catch clause.   

You can eliminate the `printlns`.  They are there so you can see the data passed to the glue code.  

The first time you run the Translator, you should rename the glue file `Feature_Examples_glue.tmpl`to the language appropriate suffix
(e.g. rename it from `.tmpl` to `.java`).  You will be making changes in this file to 
call your production code.  If you add new steps to the feature, you can copy a template for the new steps from 
the template file (`.tmpl`) to the glue source file (`.java`).  Alternatively, you can just let the IDE suggest that you need 
a new method in  Feature_Examples_glue.

Here's a possible call to an implementation in the glue file (with the `println`s eliminated):
```
    void Calculation_Convert_F_to_C(List<TemperatureCalculation> values) {
         for (TemperatureCalculation value : values) {
            try {
                TemperatureCalculationInternal i = value.toTemperatureCalculationInternal();
                int c = TemperatureCalculations.convertFahrenheitToCelsius(i.f);
                assertEquals(i.c, c, i.notes);
             } catch (Exception e) {
                System.err.println("Argument Error " + value.toString() 
				   + TemperatureCalculationInternal.toDataTypeString());
                fail("Error in calculation"); 
            }
        }
    }
```
An example production implementation might look like: 
```
public class TemperatureCalculations {
    static int convertFahrenheitToCelsius(int input) {
        return ((input - 32) * 5) / 9;
    }
}
```
You can use any step keyword for the step in the feature file, but `Calculation, Rule, or *` might be appropriate.  `*` is
from standard Gherkin.

### Data Statement
Let's take a look at the Data statement again.  
```
Data TemperatureCalculation
| Name   | Default  | DataType  | Notes  |
| F      | 0        | Integer   |        |
| C      | 0        | Integer   |        |
| Notes  |          | String    |        |
```
Now to simplify creation of the objects in a table, you create a Data statement which describes the attributes.
This creates two classes, each in their own file.  The first class has all te attributes as data type String. 
Objects of this type are created in the test file and passed to the glue methods.  

Note:  These files are recreated every time Translate runs.  If you need to import a package, your canadd it to the Configuration
or use an `Import` statement.
```
package gherkinexecutor.Feature_Examples;
class TemperatureCalculation{
    String f = "0";
    String c = "0";
    String notes = "";
    public TemperatureCalculation() { }
    public TemperatureCalculation(
        String f     ,String c     ,String notes
        ){
        this.f = f;
        this.c = c;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureCalculation _TemperatureCalculation = (TemperatureCalculation) o;
         if (
             !this.f.equals("?DNC?")
                && !_TemperatureCalculation.f.equals("?DNC?"))
                return ( _TemperatureCalculation.f.equals(this.f));
		// and 2 more clauses
                     return true;  }
    public static class Builder {
		// builder methods
        public Builder  setCompare() {
            f = "?DNC?";
            c = "?DNC?";
            notes = "?DNC?";
            return this;
            }
    @Override
    public String toString() {
		// toString cod 
        
    TemperatureCalculationInternal toTemperatureCalculationInternal() throws Exception {
        return new TemperatureCalculationInternal(
         Integer.valueOf(f)
        , Integer.valueOf(c)
        , notes
        ); 
    }
```
You'll notice an additional clauses in the `equals()` method.  A comparison of two attributes is not 
checked if either contains `$DNC$`.  This allows a comparison between a table which has all its fields (columns)
specified and one that only has a few columns specified.   

This special value can be changed in Configuration.  It is set into the attributes by specifying `compare` in the
comment after a step (e.g. `# ListOfObject TemperatureCalculation compare)`  followed by a table with only 
`F` listed would have `?DNC?` as the value of each `C` attribute. 

There is a conversion method to the internal object, which calls the appropriate conversion methoed. For data type
in other packages, you specify this conversion method in an `Import` statement, if it is not of the 
form `Construtor(String value)`

The purpose of the internal object is to provide the values in the data type that the production code expects.   

The internal object class that is created (if you don't specify a second name in the Data statement) looks like:
```
package gherkinexecutor.Feature_Examples;
import java.util.*;
class TemperatureCalculationInternal{
     Integer f;
     Integer c;
     String notes;
     
    public static String toDataTypeString() {
        return "TemperatureCalculationInternal {"
        +"Integer " 
        +"Integer " 
        +"String " 
            + "} "; }  
    TemperatureCalculation toTemperatureCalculation() {
        return new TemperatureCalculation(
        String.valueOf(f)
        ,String.valueOf(c)
        ,notes
        ); }
    public TemperatureCalculationInternal(
        Integer f         ,Integer c         ,String notes
        )  {
        this.f = f;
        this.c = c;
        this.notes = notes;
        }
    @Override
    public boolean equals (Object o) {
        // code for equals
    @Override
    public String toString() {
		// code for toString
```
The `toDataTypeString()` method can be used to print out the expected data types, in case of a conversion error. 

In this file, you can add `import` for any other classes your production code might need. 
Note that the test file only references the class with all string attributes.  The glue code is the place to
do all the conversions into a `TemperatureComparisonInternal` using the supplied method. 
```
Data TemperatureComparison
| Name   | Default  | DataType  | Notes  |
| F      | 0        | Int       |        |
| C      | 0        | Int       |        |
| Notes  |          | String    |        |
```
to call the code you create.  If you only have one row,
then you might just code that one. The string values are converted into the
internal values.  The `F` value is passed to the `TemperatureCalculations.convertFarenheitToCelsius()`
method and the return value is compared to the `C` value.
```
    fun Calculation_Convert_F_to_C(value: List<TemperatureComparison>) {
        element = value[0]
        val temp = element.toTemperatureComparisonInternal()
        assertEquals(
                temp.c,
                TemperatureCalculations.convertFarenheitToCelsius(temp.f),
                temp.notes
            )
        }
    }
```
The compiler would suggest you create a method such as follows.  The companion object is
equivalent to a class method (e.g. `static`) in other languages.
```
class TemperatureCalculations {
    companion object {
        fun convertFarenheitToCelsius(input: Int): Int {
            return ((input - 32) * 5) / 9
        }
    }
}
```
Note you can have as many columns and rows in the table as you need. 
The form in the glue code looks the same - iterate around each row. 

### A Collection Example 
In `examples.feature` is an example of dealing with a collection.   In this example, there is a collection 
of records (objects0 of the `LabelValue` type.   In the glue code for the Given, they are added to the solution object.

The interace to this object includes a method to set a filter and a method to retrieve a sum of records/objects
that match that filter.   This might be accomplshed in a single operation.   It's been split into two to show
variations in how you can pass data to the glue classes.  

Both scenarios start with a Given that provides the records.  In the first version, the values for the filter and the sum 
are provided using a ListOfObject.  Notice on the When, the table is transpose, so that it looks like You
might be entering this data into a dialog box.  
```
Scenario: Filter Data Another Way  
# filters data 
Given list of numbers # ListOfObject LabelValue
| Label | Value  |
| a     | 1      |
| b     | 2      |
| a     | 3      |
When filtered by # ListOfObject FilterValue transpose
| Name   | Label  |
| Value  | a      |
Then result # ListOfObject ResultValue 
| Sum  |
| 4    |

Data FilterValue 
| Name   | Default  | DataType  | Notes  |
| Name   |          | String    |        |
| Value  | 0        | String    |        |

Data ResultValue 
| Name  | Default  | DataType  | Notes  |
| Sum   |          | Integer   |        |

Data LabelValue 
| Name   | Default  | DataType  | Notes  |
| Label  |          | String    |        |
| Value  | 0        | Integer   |        |

```
### Passing Only One Value
Now because there is only one value that is passed to each glue function, you could simplify this feature.  The data will be
passed as a List<List<String>.   In the glue code, you use  the only element with `values.get(0).get(0)` and convert It
to the desired data type.  It is your decision as to how you want to handle this.  
```
Scenario: Filter Data 
# filters data 
Given list of numbers # ListOfObject LabelValue 
| Label | Value  |
| a     | 1      |
| b     | 2      |
| a     | 3      |
When filtered by Label with value
| a  |
Then sum is 
| 4 | 
```
## Domain Term 

Here's an example for a domain term.  The example is an ID which must have
the characteristics shown in the scenario. 
```
Scenario: Domain Term ID
Rule ID must have exactly 5 letters and begin with Q # ListOfObject ValueValid
| Value   | Valid  | Notes              |
| Q1234   | true   |                    |
| Q123    | false  | Too short          |
| Q12345  | false  | Too long           |
| A1234   | false  | Must begin with Q  |

Data ValueValid
| Name   | Default  | DataType  |
| Value  | 0        | String    |
| Valid  | false    | Boolean   |
| Notes  |          | String    |
```
In the step method, you implement a call to the method that turns a string into the object.
In this example, the constructor is called with each value in the table.  The constructor throws 
an Exception if the value is not valid.  
```
    void Rule_ID_must_have_exactly_5_letters_and_begin_with_Q(List<ValueValid> values) {
        System.out.println("---  " + "Rule_ID_must_have_exactly_5_letters_and_begin_with_Q");
        for (ValueValid value : values) {
            System.out.println(value);
            boolean result = false;
            boolean expected = Boolean.valueOf(value.valid);
            try {
                new ID(value.value);
                if (!expected) {
                    fail("Invalid value did not throw exeception "
                            + value.value + " " + value.notes);
                }
            } catch (Exception e) {
                if (expected)
                    fail("Valid value threw exeception "
                            + value.value + " " + value.notes);
            }
        }
    }

```
The constructer might look like: 
```
   public ID(String value){

        if (value.length() < 5 )
            throw new IllegalArgumentException("Too short");
        if (value.length() > 5)
            throw new IllegalArgumentException("Too long");
        if (value.charAt(0) != 'Q')
            throw new IllegalArgumentException("Must begin with Q");
    }
```
### A Method Providing Validation 
If you are using a method to perform the validation, the method might look like this:
```
boolean isValid() {
   if (value.length() < 5 )
       return false
   if (value.length() > 5)
       return false
   if (value.charAt(0) != 'Q')
       return false
   return true
   }
```
Instead of catching an Exception, you would just check the return valid of `isValid()`

## Data
Here is more information on the Data statement. 

The Data statement describes the fields of a table. 
```
Data LabelValue
| Name   | Default  | DataType  | Notes  |
| Label  |          | String    |        |
| Value  | 0        | Integer   |        |
```
 For example, this 
statement states there are two fields in `LabelValue`.  `Label` is a string 
field with the empty string as the default value. `Value` is a `Integer 
with 0 as the default value.   You can use any primitive (int, float, ..)
or associated class (Integer, Float, etc.) as the DataType. If you have an `Import` statement or 
add import in Configuration,  then you can use the data types in those packages.   
 The notes are just there to give any additional information for the field. 

For exmaple, if you favor Abstrct Data Types, e.g. `ID`, `State`, etc. you can use them
as a data type.  If they have a String constructor (e.g. `ID(String value))`
you can use it in the Data statement.  If the type requires an import from
the production package, include that import in the Configuration. 
If the creation of an object requires a different form (e.g. parse(String))
you will need to create an `Import` statement.   

Now what does having this Data statement do for you?   One or two classes 
are created.  One is the name you have specified (e.g. `LabelValue`) 
All attributes will be of the String type.  It will have an 
all attribute constructor, a toString(), an equals(), and a builder set of
methods.   The latter is used to initialize objects in the test class.

If you have more than two columns (e.g. specified the DataType), a
second class will be created with attributes of the same names, but with
the data types specified. (I refer to this as the internal class or object - as 
it is used internally for computation.) This second class will have a constructor 
with all attributes as parameters, a toString(), an equals(), and a method 
to convert it to the object with all strings.  It also has a static method
that displays the data types (for usage in error messages).   

If the second class is created, the first class will also have a method
to convert it to the internal class.  It's possible there is an invalid
value in the table, so Exception is caught if that occurs.  

Why an `Exception`, rather than something more specific?  The type of exception that can occur
for different classes is not the same.  `Exception` is the type that represents all the possible 
string conversion errors. 

The sample templates for the glue code loop through the list of objects 
and convert each one to an internal object.  

### Existing Classes 
Suppose you already had an existing class that you are going to use
in calling the production code from the glue code.  
If you specify a name of a class as the second value in the Data statement, 
then an internal class is not created.  (A file that matches what would
be created is in a .tmpl file). 
 
There will be a `to` method in the string class that creates the 
internal class.   It will pass the attributes to the internal class constructor in 
the order they are listed in the Data statement.   
```
Data LabelValueString LabelValue
| Name   | Default  | DataType  | Notes  |
| Label  |          | String    |        |
| Value  | 0        | Integer   |        |
```

### Special equals 

The equals that is created for the string class is slightly different
than the normal equals, which just compares all attributes.  If either
of the values being compared is "?DNC?", the values are not compared. 
(This can be set to something else in the Configuration.)    

How does it get to become "?DNC?"?  You could set it manually. Or 
you could use an option on the ListOfObject for a table.  If you specify 
compare, when there are fewer columns than attributes of the data, 
the fields not specified will be set to '?DNC?'.  

```
* A table to List of Object with Defaults # ListOfObject ExampleClass compare
  | FieldA  |
  | a       |
  | c       |
```


## Tables 

A table can be passed to the glue code in several ways.   If there 
is no option specifed (anything after a  `#`), it will be passed 
as a List<List<String>.  If you add the String option, the table will be
passed as a single string.  
```
Feature: Tables and Strings
Scenario: Here are table options

* A table to List of List of String   
  | aa  | bb  |
  | cc  | dd  |
  
* A table to String # String
  | aa  | bb  |
  | cc  | dd  |
```
If you specify `ListOfObject` and a _className_, it will be passed 
as `List<_ClassName_>`  You must have a Data description for that object.  

```
* A table to List of Object # ListOfObject ExampleClass
  | FieldA  | FieldB  |
  | a       | b       |
  | c       | d       |
```
If you add the keyword `transpose` as the third option, the table will be 
interpreted as the field names being in the first column.   This is 
often useful to distinquish data objects from input objects.  The 
vertical names make it appear in a dialog entry format.  
```
* A table to List of Object # ListOfObject ExampleClass transpose
  | FieldA  | a  | c  |
  | FieldB  | b  | d  |
```
Now you do not have to include all the fields from the data class. If
you do not, those fields will be filled in with the default values.   
Also, the fields can appear in any order, not just the order listed in 
the data class.  It is sometimes easier to read if they appear in 
the same order, but it's your option. 

```
* A table to List of Object with Defaults # ListOfObject ExampleClass
  | FieldA  |
  | a       |
  | c       |
```

There are a few details on tables.  The headers do not have to appear in the same order
as the Data lists them.  You do not have to have a column for every Data item.  The corresponding attribute
will be set to the default value.
### Spaces in a Value 

A blank element in a table is translated as the empty string `""`.  
You can put spaces into the table by using the `~` character.  There
will be one space for every `~`. For example:
```
* A table to List of Object with Blanks in Name # ListOfObject ExampleClassWithBlanks
  | Field 1  | Field 2  |
  | ~        | b        |
  | c        | ~        |

Data ExampleClassWithBlanks
| Name     | Default  |
| Field 1  | y        |
| Field 2  | x        |
```
### Alternatives for passing single values 
You have two alternatives passing single values to the glue code.  In this
example, the Given uses a ListOfObject.  
The first When and Then, alos use ListOfObject 

The When appears like the user might select something to filter on 
and a value for the filter.   
``` Name   | Label  |
| Value  | a      |
```
The Then step gives the domain term for the answer 4.
```
Then result # ListOfObject ResultValue
| Sum  |
| 4    |
```
Here's the full Scenario:
```
Scenario: Filter Data Another Way  
# filters data 
Given list of numbers # ListOfObject LabelValue
| Label | Value  |
| a     | 1      |
| b     | 2      |
| a     | 3      |
When filtered by # ListOfObject FilterValue transpose
| Name   | Label  |
| Value  | a      |
Then result # ListOfObject ResultValue 
| Sum  |
| 4    |

Data FilterValue 
| Name   | Default  | DataType  | Notes  |
| Name   |          | String    |        |
| Value  | 0        | String    |        |

Data ResultValue 
| Name  | Default  | DataType  | Notes  |
| Sum   |          | Integer   |        |

Data LabelValue 
| Name   | Default  | DataType  | Notes  |
| Label  |          | String    |        |
| Value  | 0        | Integer   |        |
```
In this version, the values for When and Then are passed as the single
element in a `List<List<String>`.   
You just obtain `values.get(0).get(0)` and use that.  It`s a good 
practice to include the domain term in the step, so that people will
know what it is. 
```
When filtered by Label with value
| a  |
Then sum is 
| 4 | 
```

## Strings 
You can pass a multiline string to the glue code. If you include `ListOfString`, the glue code
will receive the string as a List<String>, instead of a String.  
```
Scenario: Here are string options

* A multiline string to a string
  """
  One line
  Two line
  """

* A multiline string to a List of String # ListOfString
  """
  Three line
  Four line
  """

```

## Import 
One final statment is the `Import` statement.  It appears like this:
```
Import 
| Datatype    | ConversionMethod    | Import                   | Notes                 |
| URL         | new URL($)          | java.net.URL             |                       |
| Pattern     | Pattern.compile($)  | java.util.regex.Pattern  |                       |
| Weekday     | Weekday.valueOf($)  |                          | Enum that is created  |
| BigInteger  | new BigInteger($)   | java.math.BigInteger     |                       |
```
If you use a class other than the primitive equivalents (e.g. Integer),
you need to include it as an import.  You specify the conversion 
method from a String, using `$` to show where the string value goes.  
Under Import, you specify the import statement (import and ; will automatically
be added.)  If you do not specify an import location, then the code 
assumes it will be available without one.   

Note, you should add the production package to the imports in the Configuration
attributes.  That way, it will automatically be put in each of the 
generated files.  
Now you can use these data types in a Data statement.
```agsl
Data Imports 
| Name       | Default             | Datatype    | Notes           |
| myURL      | http://kenpugh.com  | URL         | Uses import     |
| myPattern  | a.*                 | Pattern     | Uses a pattern  |
| myWeekday  | MONDAY              | Weekday     | Uses an enum    |
| myBigInt   | 1                   | BigInteger  | Uses import     |

```
And the ListOfObject looks just the same.
```
Scenario: Use an import
Given this data # ListOfObject Imports 
| myURL                | myPattern  | myWeekday  | myBigInt     |
| http://kenpugh.com   | a.*        | MONDAY     | 1            |
| http://atdd-bdd.com  | [ab]       | SUNDAY     | 10000000000  |
```
The conversion method is called in the data classes that are created.
Exception is caught, so that you can report that the values were not
valid for the particular data type. 
```
Scenario: Should also fail
Given this data should fail # ListOfObject Imports 
| myURL                | myPattern  | myWeekday  |
| ht://kenpugh.com   | a.*        | MONDAY     |
| http:atdd-bdd.com  | [ab]       | SUNDAY     |

```


## Configuration 

Here are the `Configuration` parameters in `Translate`.  

These values should work for the default JetBrains layout.  You can alter them for another project layout.

You can move the configuration class out of Translate into a separate file.   That way, if you ever reload
Translate, you can delete the Configuration class in the new Translate and keep using the one you have changed.

```        
    static class Configuration {

        public static final boolean inTest = false;  // switch to true for development of Translator
        public static final boolean traceOn = false; // Set to true to see trace
		
        public static final char spaceCharacters = '~'; // Will replace with space in table values

        public static final String doNotCompare = "?DNC?";  // Value used for not comparing an attribute
        public static String currentDirectory = "";  // For printout to check where IDE is running 

        public static final String featureSubDirectory = "src/test/java/"; // where features are to be found
        public static final String packageName = "gherkinexecutor";
        public static final String testSubDirectory = "src/test/java/" + packageName + "/"; 
				// where the files containing the test, glue, and data files (inside package with Feature name)
		
        public static final String dataDefinitionFileExtension = "java"; // "tmpl"; 
			// change to .tmpl if altering data classe, becuase data class files are rewritten every time. 

        public static final List<String> linesToAddForDataAndGlue = new ArrayList<>();
		// These lines will be added to the glue file and the data class files 
        // Must include semicolon if needed
        static {
            linesToAddForDataAndGlue.add("import java.util.*;");
        }

        public static final List<String> featureFiles = new ArrayList<>();
		// These feature files will always be translated.
        static {
            featureFiles.add("import.feature");
            featureFiles.add("include.feature");
//            featureFiles.add("full_test.feature");
//            featureFiles.add("GherkinTranslatorFullTest.feature");
        }
    }```

### A Larger Domain Example 

Here is domain related example.   A Forecast is a Domain Term that has multiple attributes.
The data type for each attribute is shown, along with a default value.  
```
Data Forecast
| Name        | Default   | Datatype           | Notes               |
| Day         | 1/1/2025  | Date               |                     |
| Time        | 12:00 am  | Time               |                     |
| High        | 100       | Temperature        | High Temperature    |
| Low         | 0         | Temperature        | Low Temperature     |
| Rain        | 0         | Percentage         | Chance of Rain      |
| Wind Speed  | 0         | Speed              |                     |
| Direction   | N         | CompassDirection   |                     |
| Condition   | Clear     | WeatherCondition   | Cloudy, Rain, etc.  |
```
Here's a possible story to search forecasts for those that meet certain conditions:
```
Scenario: Search Forecast
Given forecast is           # ListOfObject Forecast
| Day       | Time      | High  | Low  | Rain  | Wind Speed  | Direction  | Condition  |
| 1/1/2025  | 12:00 am  | 70    | 60   | 0     | 1           | N          | Clear      |
| 1/3/2025  | 12:00 am  | 60    | 40   | 10    | 5           | S          | Cloudy     |
# And many more  (or read from CSV file)
When searching for          # ListOfObject # ForecastSearchCriteria 
| Field        | Relationship  | Value  |
| High         | >             | 65     |
| Wind Speed   | <             | 5      |
Then results are # ListOfObject Forecast 
| Day       | Condition  |
| 1/1/2025  | Clear      |
```
The Given step uses the domain term defined in the previous block. The data could be
listed here, read from a CSV file, or put onto a database. The When step gives the search
criteria.  The Triad would define how these criteria should work.
Finally the Then step shows the expected results.   






### Addendum 
#* A table to List of List of Object with String Constructor # ListOfList URL
#| https://kenpugh.com   |
#| https://atdd-bdd.com  |
# Note - the class must be imported into the test and the glue code
# This scenario has been commented out so that the Translator Acceptance Tests can run
# without having to import URL.   See the tictactoe game for an example.
