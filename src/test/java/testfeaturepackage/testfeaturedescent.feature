Feature: Test Feature

Scenario Include something 
Given local include
"""
Include "string.inc"
"""
Given global include
"""
Include 'string.inc' 
"""

Scenario: Run Something
Given something # ListOfObject Something
| In  | Out  |
| 1   | 2    |

Data Something
| Name  | Default  |
| In    | 0        |
| Out   | A        |


