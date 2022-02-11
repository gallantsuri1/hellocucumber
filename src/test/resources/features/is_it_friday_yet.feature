Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario Outline: Sunday isn't Friday
    Given today is <inputDay>
    When I ask whether it's Friday yet
    Then I should be told <expectedAnswer>
    Examples:
      | inputDay      | expectedAnswer |
      | "Sunday"      | "Nope"         |
      | "Friday"      | "Yeah"         |
