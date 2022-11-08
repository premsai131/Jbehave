Narrative: In order to book a flight with source and Destination values



Scenario: As a user i shouldnot select source and destination as the same

Given iam in hyderabad
When i choose my source location as <source>
Then select my destination location as <destination>

Examples:
|source|destination|
|Hyderabad|Bangalore|
|Pune|Chennai|
|Mumbai|Delhi|



!-- Scenario: As a user is should be able to select destination other than source location
!-- Given iam in hyderabad
!-- When source location is selected as Hyderabad
!-- Then I choose my destination location as Bangalore


