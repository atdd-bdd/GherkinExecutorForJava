



# Gherkin Translator 

## Summary 
The Gherkin Translator simplifies the creation of test code from a Gherkin feature file. 
It creates collections of objects and values that can be used to test the production code. 
It is designed to work the same way with any implementation language.

## Why Use Gherkin?
Gherkin feature files are readable executable documentation.  If a requirement / story
includes buiness rules,
they provide a convenient form to collaborate with non-programmers.   They 
also provide a way to document parts of a domain driven design.
For a developer they provide an alternative way to specify the values used 
to call a parametrized test method.  

The scenarios can be used in user documentation.
For domains which have two-dimensional objects, the tabluar format can be much easier
to comprehend. (See the tic-tac-toe example.)

Here are a few introductory examples. The first shows a calculation from Fahrenheit to
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
| F    | C       | Notes                     |
| 33   | .555    | How many decimal digits?  |
```
The Triad would then discuss how it should appear on an output (e.g. the screen). Note that
the internal representation of F or C is irrelevant - it could be double, Double, BigInteger, or
something else.   

If your code style is to use Abstract Data Types, you can use a table to show allowable values.
```
Scenario: Domain Term ID 
Rule ID must have exactly 5 letters and begin with Q # ListOfObject DomainTermID
| Value   | Valid  | Notes              |
| Q1234   | true   |                    |
| Q123    | false  | Too short          |
| Q12345  | false  | Too long           |
| A1234   | false  | Must begin with Q  |
```
Now this could be used in a help file to show examples.  

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


## How It Works in Brief

The translator converts a Gherkin feature file into a unit test file.
The unit test file calls a glue file which the developer edits to call the code under 
test. The translator also creates a template for the glue file.  

The Translator is a single file containing all the necessary components. 
To translate a feature file, you supply the feature files you want converted by either adding them 
to a list in the Translator or adding them as program arguments.  

Unlike other implementations of Gherkin,
each feature file is associated with one unit
test file, its glue file, and its class file.

If you need the same data types in multiple files, you can use the `Include` statement
to add those data types to a feature. For example, `Include "datadefs.txt"`would add whatever
is in that file to the feature file before it is translated.   

## Why Not Use Existing Frameworks? 

I've been using Cucumber, one of the most common applications that uses 
Gherkin for a number of years.  You can have a table after each step.   However you
need to add additional code to use that table as a list of objects.  The means for doing 
so has changed from version to version.  The code for doing so has gotten more complex.     

The Translator converts the Gherkin tables into initialized lists. The developer just needs to 
specify the class of the objects that will be in those lists. It does not depend on 
features of a specific languages, such as introspection. 

The initial version of Translator was written for Kotlin.  It was converted to Java and 
other facerts were added. It is currently being converted
to Kotlin, Python, and C++.    A feature file written for one language should work
in the other languages.  The only issues would be replacing the Datatype of a field (e.g. Int)
with the appropriate type in another language.  

Since the entire source code is supplied, a developer can alter the translation to
their preferred style.  For example, if methods should not have underscores, 
that can be changed in a single line.  

## How It Differs From Other Frameworks 
The Translator passes data to steps only through tables.  There are no values embeeded the
the steps.  The domain term which a value represents is the header of a column
which contains the values.  

The tables can be passed as a list of objects or a list of strings.   

## How It Works in Detail
Here is a feature file.  
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
In the test directory, it is named "examples.feature".  The words after the keyword 
`Feature` are combined into the name of the feature.  Let's assume that you are using the translator with Java (language suffix .java) 
The operation is the same, the output code depends on the language. 

To translate this file, you can pass it as a parameter to the `Translate` main method.  Alternatively
you can add it to the Configuration list of feature files.   

The single step in the `Scenario` ("Convert F to C ") is passed a list of objects of 
`TemperatureComparison`.
A unit test file with the name `Feature_Examples.java` (with language appropriate suffix) is created in a directory with the same name. 
A another file is created called `Feature_Examples_glue.tmpl` is also created.  This contains code that is called 
from `Feature_Examples.java`.  A third file `Feature_Examples_data.tmpl` is created.  This
contains the declarations for the classes.

The `Feature_Examples.java` example file contains code that looks like:

```
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
The glue template file looks like the following:
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
if `a` is in the table for a field with datatype `int`

The first time you run the Translator, you should rename that file to the language appropriate suffix
(e.g. rename it from .tmpl to .java).  You will be making changes in this file to 
call your production code.  If you add new steps to the feature, you can copy a template for the new steps from 
the template file (.tmpl) to the glue source file (.java).  Alternatively, you can just let the IDE suggest that you need 
a new method in  Feature_Examples_glue.

Here's a possible call to an implementation in the glue file:
```
    void Calculation_Convert_F_to_C(List<TemperatureCalculation> values) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
         for (TemperatureCalculation value : values) {
            System.out.println(value);
            try {
                TemperatureCalculationInternal i = value.toTemperatureCalculationInternal();
                int c = TemperatureCalculations.convertFahrenheitToCelsius(i.f);
                assertEquals(i.c, c, i.notes);
             } catch (Exception e) {
                System.err.println("Argument Error " + value.toString() + TemperatureCalculationInternal.toDataTypeString());
                fail("Error in calculation"); 
            }
        }
    }
```
An example implementation might look like: 
```
public class TemperatureCalculations {
    static int convertFahrenheitToCelsius(int input) {
        return ((input - 32) * 5) / 9;
    }
}
```

The two words after the comment sign # denote that data format that is passed to the glue code and the class name. 
For `Feature_Examples`, the table values will be converted to a List of objects of type `TemperatureComparison`. 

```
Feature: Examples

Scenario: Temperature 
# Business rule or Calculation 
Calculation Convert F to C # ListOfObject TemperatureComparison 
| F    | C    | Notes       |
| 32   | 0    | Freezing    |
| 212  | 100  | Boiling     |
| -40  | -40  | Below zero  |
```
The `Calculation` is a new keyword that is a synonym for `*` in Gherkin.  In the translator, you could also use `Rule` or `*` instead.
This turns into code in  `Feature_Examples.java`:
```
class Feature_Examples{
    @Test
    fun test_Scenario_Temperature(){
        val feature_Examples_glue_object = Feature_Examples_glue()

        val objectList1 = listOf<TemperatureComparison>(
            TemperatureComparison(
                f = "32",
                c = "0",
                notes = "Freezing",
                ),
            TemperatureComparison(
                f = "212",
                c = "100",
                notes = "Boiling",
                ),
            TemperatureComparison(
                f = "-40",
                c = "-40",
                notes = "Below zero",
                ),
            )
        feature_Examples_glue_object.Calculation_Convert_F_to_C(objectList1)
        }

```
Now to simplify creation of the objects in a table, you create a data description.
The `Data TemperatureComparison` portion produces code in the test file that
declares a `TemperatureComparison` class.  Every attribute in this class is `String` type. Since the table also contains the data types for each element
in this class, a second class with the default name `TemperatureConversionInternal` is also created.  You can attempt to
create an instance of this class in the glue code to check that the format of each element in the table is acceptable.

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
The `Data` statement turns into code in `Feature_Examples_data.tmpl` that looks like the following.
If you add another work, the internal class will be named by that word, rather than
the created one: `TemperatureComparisonInternal`
```
asdfasdflkasjdfojsa;ldjjfddata class TemperatureComparison(
    val f: String = "0",
    val c: String = "0",
    val notes: String = "", ) {
    fun toTemperatureComparisonInternal() : TemperatureComparisonInternal{
        return TemperatureComparisonInternal(
            f.toInt(),
            c.toInt(),
            notes,) 
    }
        
data class TemperatureComparisonInternal(
    val f: Int= "0".toInt(),
    val c: Int= "0".toInt(),
    val notes: String= "",)
```
The first time you run the Translator, rename this file 
The other file that is created is `Feature_Exmaples_glue.tmpl"
Again, just rename this file to language suffix. 


Here is what the template that is created for the corresponding function 
in the glue `.tmpl` file looks like: 
```
class Feature_Examples_glue {
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
This prints out 

Now comes your part.  Add the appropriate code to this glue function
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
The construction might look like: 
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

If you are using a method to perform the validation, the glue code might look like this.   Note
this is just about what a unit test would look like, except for the loop around the list.

```

```
and the method might look like this
```
    fun isValid(): Boolean {
        if (this.value.length < 5 )
            return false
        if (this.value.length > 5)
            return false
        if (this.value.get(0) != 'Q')
            return false
        return true
    }
```
If the method throws an exception on errors, you catch and check that in here.
```
   fun Rule_ID_must_have_exactly_5_letters_and_begin_with_Q( value : List<DomainTermID>) {
        println("---  " + "Star_ID_must_have_exactly_5_letters_and_begin_with_Q")
        for (element in value) {
            val temp = element.toDomainTermIDInternal()
            try {
                ID(temp.value)
                if (!temp.valid)
                    fail("Value of " + temp.value + "accepted but should fail")
            }
            catch(e: Exception){
                if (temp.valid)
                    fail("Value of " + temp.value + "failed but should be accepted")
                assertEquals(temp.notes, e.message, "Message does not mathc")
            }
       }
    }
}
```
This is what the constructor might look like
```
data class ID(val value: String) {
    init {
        if (this.value.length < 5 )
            throw Exception("Too short")
        if (this.value.length > 5)
            throw Exception("Too long")
        if (this.value.get(0) != 'Q')
            throw Exception("Must begin with Q")
    }
```
In this case, the test also checks that the message exception matches 
what is given in the scenario table.  
## Data 
The Data statement describes the fields of a table.  For example, this 
statement states there are two fields in `LabelValue`.  `Label` is a string 
field with the empty string as the default value. `Value` is a `Integer 
with 0 as the default value.   You can use any primitive (int, float, ..)
or associated class (Integer, Float, etc.) as the DataType.  The notes
are just there to give any additional information for the field. 

If use Abstrct Data Types, e.g. `ID`, `State`, etc. you can use them
as a data type.  If they have a String constructor (e.g. `ID(String value))`
you can use it in this statement.  If the type requires an import from
the production package, include that import in the Configuration. 
If the creation of an object requires a different form (e.g. parse(String))
you will need to create an Import statement.   
```
Data LabelValue
| Name   | Default  | DataType  | Notes  |
| Label  |          | String    |        |
| Value  | 0        | Integer   |        |
```
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

```
        val inTest = false  // switch to true for development of Translator
        var traceOn = false // set to true to see trace
        var spaceCharacters = '~'  // Will replace with space in tables
        var currentDirectory = ""
        var featureSubDirectory = "src\\test\\kotlin\\"
        var packageName = "gherkinexecutor"
        var testSubDirectory = "src\\test\\kotlin\\" + packageName + "\\"
        var dataDefinitionFileExtension = "tmpl" // change to kt if altering data file
        val featureFiles = mutableListOf(
```


## Inspiration 
This form for expressing shared understanding came from Ward Cunningham's FIT
(Framework for Integrated Testing).  Gherkin came from Aslak Hellesøy.  Running a program
to create the code came from Gojko Adzic.   



### Addendum 
#* A table to List of List of Object with String Constructor # ListOfList URL
#| https://kenpugh.com   |
#| https://atdd-bdd.com  |
# Note - the class must be imported into the test and the glue code
# This scenario has been commented out so that the Translator Acceptance Tests can run
# without having to import URL.   See the tictactoe game for an example.
