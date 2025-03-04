# How It Works in Detail
Here is more information on how GherkinExecutor works. 

## Example Feature
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
(language suffix `.java`).  The operation is the same, the output code depends on the language. 

To translate this feature file, you can pass it as a parameter to the `Translate` main methood, 
add it to the Configuration list of feature files, or let the directory tree search find it.      
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
   
The single step in the `Scenario` ("Convert F to C ") has additional information `# ListOfObject TemperatureComparison`.  So 
the test file / glue code parameters use a `List<TemperatureComparison>`to pass this data between the two.  This
class has all attributes as Strings (so is referenced as the string object).   

Note that a new glue object is created for each Scenario.   This makes each test independent.   If you need 
to share values between scenarios, create a class variable (e.g. static or companion object).  

### Test File 
The `Feature_Examples.java` example file contains code that looks like
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
This file is recreated everytime Translate is run.  You run Translate everytime you change the feature file.    
### Glue File 
The `Feature_Examples_glue.tmpl` file has the following in it. 
```
   void Calculation_Convert_F_to_C(List<TemperatureCalculation> values ) {
        System.out.println("---  " + "Calculation_Convert_F_to_C");
        for (TemperatureCalculation value : values){
             System.out.println(value);
             // Add calls to production code and asserts
              TemperatureCalculationInternal i = value.toTemperatureCalculationInternal();
              }
		fail("Must implement"); 
    }

```
Note that this loop may throw and IllegalArgumentException.  It's possible that the values
in the table are not valid for the types for the field.   For example, 
if `a` is in the table for a field with datatype `int`, then an IllegalArgumentException is thrown and will be
caught by the test framework.   

You can eliminate the `println`.  It is  there so you can see the data passed to the glue code, wihtout having to 
look back at the feature file.   

The first time you run the Translator, you should rename the glue file `Feature_Examples_glue.tmpl`to the language appropriate suffix
(e.g. rename it from `.tmpl` to `.java`).  You will be making changes in this file to 
call your production code.  If you add new steps to the feature, you can copy a template for the new steps from 
the template file (`.tmpl`) to the glue source file (`.java`).  Alternatively, you can just let the IDE suggest that you need 
a new method in  Feature_Examples_glue.

Here's a possible call to an implementation in the glue file (with the `println`s eliminated).  Note you provide essentially
the same code that you would in a unit test. The data is provided in the parameter, as would be in a parameterized unit
test.   
```
    void Calculation_Convert_F_to_C(List<TemperatureCalculation> values) {
         for (TemperatureCalculation value : values) {
                TemperatureCalculationInternal i = value.toTemperatureCalculationInternal();
                int c = TemperatureCalculations.convertFahrenheitToCelsius(i.f);
                assertEquals(i.c, c, i.notes);
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
Let's take a look at the Data statement again. Here's the example:  
```
Data TemperatureCalculation
| Name   | Default  | DataType  | Notes  |
| F      | 0        | Integer   |        |
| C      | 0        | Integer   |        |
| Notes  |          | String    |        |
```
To simplify creation of the objects in a table, you create a Data statement which describes the attributes.
Since the `DataType` field is specified, this statement creates two classes, each in their own file.  The first class 
has all attributes as data type String.  This is referred to as the string object.   
Objects of this type are created in the test file and passed to the glue methods.   The second class has the same
names for the attributes but the data types are those listed (e.g. `Integer`).  This second class has `Internal` appended 
to the name (`TemperatureCalculationInternal`

Note:  These files are recreated every time Translate runs.  If you need to import a package, your canadd it to the Configuration
or use an `Import` statement.  Here's an example of the `TemperatureCalculation` class: 
```
package gherkinexecutor.Feature_Examples;
class TemperatureCalculation{
    String f = "0";
    String c = "0";
    String notes = "";
    public TemperatureCalculation() { }
    public TemperatureCalculation(
        String f     ,String c     ,String notes){
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
                if (!_TemperatureCalculation.f.equals(this.f)) return false; 
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
        
    TemperatureCalculationInternal toTemperatureCalculationInternal() throws IllegalArgumentException {
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
comment after a step (e.g. `# ListOfObject TemperatureCalculation compare)`.   For example, if this werefollowed by a table 
with only an `F` column, every `C` attribute. would have `?DNC?` as its value.     

There is a conversion method to the internal object, which calls the appropriate conversion methoed. For data types
in other packages, you need to specify this conversion method in an `Import` statement, if it is not of the 
form `Construtor(String value)`

The purpose of the internal object is to provide the values in the same data types that the production code expects.   

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
        Integer f         ,Integer c         ,String notes)  {
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

In this file, you can add `import` for any other classes your production code might need use by adding it to
the `Configuration`
```
        public static final List<String> linesToAddForDataAndGlue = new ArrayList<>();
        // Imports or other lines to add to data class and glue class
        // Must include  semicolon if needed
        static {
            linesToAddForDataAndGlue.add("import java.util.*;"); // as an example
        }
```  
Note that the test file only references the class with all string attributes.  The glue code is the place to
convert the string object  into a `TemperatureComparisonInternal` object using the supplied method.  
### Notes 
Note you can have as many fields as you like in the Data statement. The form in the glue code looks the 
same - iterate around each row. 
## Import statement
The `Import` statement is used to show conversion methods for library and custom classes.  It can also specify the 
`import` statements required for the library or custom classes.   
```
Import 
| Datatype    | ConversionMethod    | Import                   | Notes                 |
| Pattern     | Pattern.compile($)  | java.util.regex.Pattern  |                       |
| Weekday     | Weekday.valueOf($)  |                          | Enum that is created  |
| BigInteger  | new BigInteger($)   | java.math.BigInteger     |                       |
```
You specify the conversion 
method from a String, using `$` to show where the string value goes.  
Under Import, you specify the import statement (`import` and `;` will automatically
be added.)  If you do not specify an import location, then the code 
assumes it will be available without one (e.g. you added to the Configuration file).     

If you use a class other than the primitive equivalents (e.g. Integer),
you may need to include it in `Import`. In particular, if the class does not have a constructor that 
takes a String as its sole parameter.  For example, all `enums` use a `valueOf()` method.  

Note, you should add the production package to the imports in the Configuration
attributes.  That way, it will automatically be put in each of the 
generated files. 
 
Now you can use any of these data types in a Data statement,e.g.:   
```
Data MyDataClass  
| Name       | Default             | Datatype    | Notes           |
| myPattern  | a.*                 | Pattern     | Uses a pattern  |
| myWeekday  | MONDAY              | Weekday     | Uses an enum    |
| myBigInt   | 1                   | BigInteger  | Uses import     |
```
And the ListOfObject looks as any other: 
```
Scenario: Use an import
Given this data # ListOfObject MyDataClass 
| myPattern  | myWeekday  | myBigInt     |
| a.*        | MONDAY     | 1            |
| [ab]       | SUNDAY     | 10000000000  |
```
The conversion method is called in the data classes that are created.  
```
Scenario: This should fail 
Given this data # ListOfObject MyDataClass 
| myPattern  | myWeekday  | myBigInt     |
| a.*        | JANUARY    | 1            |
| [ab]       | SUNDAY     | abc          |

