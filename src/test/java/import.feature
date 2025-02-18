Feature: Import

# creates the import statements for all the files (including the data files) 

Import 
| Datatype  | Import        | From String   |
| URL       | net.whatever  | URL.parse(^)  |
| Pattern   | regex.*       | Pattern.x(^)  |

Scenario: Use an import
Given this data # ListOfObject Imports 
| myURL                | myPattern  |
| http://kenpugh.com   | a.*        |
| http://atdd-bdd.com  | [ab]       |

Data Imports 
| Name       | Default               | Datatype  | Notes           |
| myURL      | http://kenpugh.com    | URL       | Uses import     |
| myPattern  | a.*                   | Pattern   | Uses a pattern  |
