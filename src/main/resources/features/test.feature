Feature:Check content

  Scenario: Number of games
    When user goes to games.williamhill.com
    And user logs into the portal
    And user displays A-Z list
    Then user can count number of games