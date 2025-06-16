@reg
Feature: User Login

  Background: Given user open the application url

  @smoke @validcredentials
  Scenario Outline: Login with the valid credentials
    When user enter valid email "<email>" and password "<password>"
    And user clicks on the Login button
    Then Homepage should be displayed
    Examples:
      | email | password |
      | Admin | admin123 |

  @invalidcredentials
  Scenario Outline: Login with the Invalid email credentials
    When user enter Invalid email "<email>" and password "<password>"
    And user clicks on the Login button
    Then Alert should display in the Login page.
    Examples:
      | email     | password |
      | Admintutt | admin123 |

  @invalidcredentials
  Scenario Outline: Login with the Invalid password credentials
    When user enter valid email "<email>" and password "<password>"
    And user clicks on the Login button
    Then Alert should display in the Login page.
    Examples:
      | email | password    |
      | Admin | admin123456 |

  @emptyemail
  Scenario Outline: Login with the Empty email
    When user enter empty email "<email>"
    And user clicks on the Login button
    Then Alert should display in the Login page with required alert.
    Examples:
      | email | password    |
      | ""    | admin123456 |

  @emptypassword
  Scenario Outline: Login with the Empty Password
    When user enter empty password "<password>"
    And user clicks on the Login button
    Then Alert should display in the Login page with required alert.
    Examples:
      | email | password |
      | Admin | ""       |







