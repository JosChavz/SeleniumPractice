Feature: Google Haikyu!! Wikipedia Test
  Scenario: Successfully search Haikyu!! using Google
    Given User is on Google
    When User Searches
      | Keyword           | Result                                                       |
      | Haikyu!!          | https://en.wikipedia.org/wiki/Haikyu!!                       |
      | Run with the Wind | https://myanimelist.net/anime/37965/Kaze_ga_Tsuyoku_Fuiteiru |
    And Clicks on the first result
    Then Wikipedia should be on display