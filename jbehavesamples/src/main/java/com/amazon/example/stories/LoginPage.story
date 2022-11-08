Narrative: Verify login functionality of amazon website


Scenario: Verify login to amazon website with invalid usernames
Given user is on amazon login page
When user enters the username as <username>
Then user should see invalid username error after clicking on continue button

Examples:
|username|
|premsai|
|12jor#$@|
|mike~0224%#@gmail.com|

Scenario: Verify login to amazon with invalid passwords

Given user is on amazon login page
When user enters username as premsai23@gmail.com
Then user clicks on continue button
And user enters password as <password>
Then user should see error message after clicking on signin button

Examples:
|password|
|wqiuaskj|
|asdkhas83972324|


!-- Scenario: Verify login to amazon with valid credentials
!--
!-- Given user is on amazon login page
!-- When user enters username of premsaiinfotech@gmail.com
!-- Then user clicks on continue button
!-- Then user enters password as password and clicks on signin button
!-- And user should be successfully signedin and sees home page
!-- Then user should see user's name in accounts&lists section




