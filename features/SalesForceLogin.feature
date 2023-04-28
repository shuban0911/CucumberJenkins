Feature: Salesforce Login Module

#@input
Scenario: Login with valid username and password

Given User is on the login page
Then User enters username "oct2022@abcd.com" and password "shuban0911"
When User clicks the login button

#@ex1
Scenario Outline: Login with valid username and password

Given User is on the login page
Then User enters "<username>" and "<password>"
When User clicks the login button

Examples:
|username|password|
|Shuban2022@abcd.com|shuban0911|

#@ex
Scenario: Login with valid username and password

Given User is on the page "LoginPage"
When User enters user and pass
|username|password|
|oct2022@abcd.com|shuban091112|
When User clicks the login button

