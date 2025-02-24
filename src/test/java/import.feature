Feature: Import

# creates the import statements for all the files (including the data files) 

Import 
| Datatype    | ConversionMethod    | Import                   | Notes                 |
| URL         | new URL($)          | java.net.URL             |                       |
| Pattern     | Pattern.compile($)  | java.util.regex.Pattern  |                       |
| Weekday     | Weekday.valueOf($)  |                          | Enum that is created  |
| BigInteger  | new BigInteger($)   | java.math.BigInteger     |                       |

Scenario: Use an import
Given this data # ListOfObject Imports 
| myURL                | myPattern  | myWeekday  | myBigInt     |
| http://kenpugh.com   | a.*        | MONDAY     | 1            |
| http://atdd-bdd.com  | [ab]       | SUNDAY     | 10000000000  |


Scenario: Should fail 
Given this data should fail # ListOfObject Imports 
| myURL                | myPattern  | myWeekday  |
| http://kenpugh.com   | a.*        | SOMEONE    |
| http://atdd-bdd.com  | [ab]       | SUNDAY     |

Scenario: Should also fail
Given this data should fail # ListOfObject Imports 
| myURL                | myPattern  | myWeekday  |
| ht://kenpugh.com   | a.*        | MONDAY     |
| http:atdd-bdd.com  | [ab]       | SUNDAY     |



Data Imports 
| Name       | Default             | Datatype    | Notes           |
| myURL      | http://kenpugh.com  | URL         | Uses import     |
| myPattern  | a.*                 | Pattern     | Uses a pattern  |
| myWeekday  | MONDAY              | Weekday     | Uses an enum    |
| myBigInt   | 1                   | BigInteger  | Uses import     |
