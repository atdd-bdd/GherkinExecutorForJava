
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



