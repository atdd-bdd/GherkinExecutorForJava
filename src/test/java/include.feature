Feature: Include 

Scenario: An include 
Given a string include
""" 
Include "string.inc"
"""

Scenario: An include of CSV file
Given a table 
Include "TableExample.csv"


