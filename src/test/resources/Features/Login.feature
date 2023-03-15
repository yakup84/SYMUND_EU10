Feature: Login fonctionality
  User Story:As a user, I should be able to login.
Background:
Given user opens a browser and goes to login page

  Scenario Outline:Verify user can login with valid credentials (by clicking on the "Login button" )
When user enter a valid "<user name>" into user field
    And user enter a valid "Employee123" into password field
    And user click Login button
    Then user should land on the home page
    Examples:
      | user name   |  |
      | Employee130 |  |
      | Employee180 |  |
  Scenario Outline:Verify user can login with valid credentials (by entiring on key board" )
    When user enter a valid "<user name>" into user field
    And user enter a valid "Employee123" into password field and click enter
    Then user should land on the home page
    Examples:
      | user name   |  |
      | Employee130 |  |
      | Employee180 |  |

    Scenario Outline: Verify User can not login with any invalid credentials(Wrong username or password)
      When user enter invalid "<user name>" or"<password>" into user and password field
      And user click Login button
      Then should be displayed "Wrong username or password." message
      Examples:
        | user name   | password    |
        | asdr12      | Employee123 |
        | Employee130 | sdgsdg      |
        | sdgdsgr     | fhfkhkgf25  |

  Scenario Outline:Verify  user can not login if the password or username is empty
    When user enter blank "<user name>" or"<password>" into user and password field
    And user click Login button
    Then should be displayed "Please fill out this field" message
    Examples:
      | user name   | password    |
      |             | Employee123 |
      | Employee130 |             |
      |             |             |

Scenario:Verify user can see the password in a form of dots by default
  When  user enter  "Employee123" into password field
  Then user should see the password in a form of dots

  @SYMUND
  Scenario:Verify user can see the password explicitly if needed
    When  user enter  "Employee123" into password field
    And user click eye button near password
    Then user should see the password explicitly
  @SYMUND
  Scenario:Verify User can see the "Forgot password?" link on the login page
    Then user should see the Forgot password? link
  @SYMUND
    Scenario: Verify User can see the  "Reset Password" button on the next page after clicking on forget password link
      When User click Forgot password? link
      Then User should see Reset Password link