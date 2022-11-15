Narrative: Verify restoring the session using cookies

Scenario: Verify login to the Website using session store

Given user is on Amazon home page
When user tries to restore session details
Then user should be logged in and should see user's name in header section