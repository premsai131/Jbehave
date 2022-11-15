Narrative: Verify login functionality of amazon website

Meta:
@author Mauro
Scenario: Verify login to amazon website with invalid usernames
Given user is on amazon login page
When user enters the username as <username>
Then user should see invalid username error after clicking on continue button

Examples:
|username|
|premsai|
|12jor#$@|
|mike~0224%#@gmail.com|

Meta:
@theme filtering
Scenario: Verify login to amazon with invalid passwords

Given user is on amazon login page
When user enters username as premsai@gmail.com
Then user clicks on continue button
And user enters password as <password>
Then user should see error message after clicking on signin button

Examples:
|password|
|wqiuaskj|
|asdkhas83972324|


Meta:
@skip
Scenario: Verify login to amazon with valid credentials

Given user is on amazon login page
When user enters username as 9100249549
Then user clicks on continue button
And user enters password and clicks on signin button
Then user should see user's name in accounts&lists section




