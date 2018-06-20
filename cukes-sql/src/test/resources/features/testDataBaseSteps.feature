Feature: Test DataBaseSteps

  Scenario: DB matches rows
    Then DB table Person should match:
      | id | name  | surname | age |
      | 1  | Anju  | Ujna    | 5   |
      | 2  | Sonia | Ainos   | 19  |
      | 3  | Asha  | Tear    | 35  |


  Scenario: DB contains rows
    And DB table Person should contain:
      | id | name  |
      | 1  | Anju  |
      | 2  | Sonia |
      | 3  | Asha  |

    And DB table Person should contain:
      | name  | age |
      | Anju  | 5   |
      | Sonia | 19  |

  Scenario: ContextInflater for table
    Given let variable "name" equal to "Anju"
    And  let variable "surname" equal to "Ainos"

    Then DB table Person should match:
      | id | name     | surname     | age |
      | 1  | {(name)} | Ujna        | 5   |
      | 2  | Sonia    | {(surname)} | 19  |
      | 3  | Asha     | Tear        | 35  |

    Then DB table Person should contain:
      | name     | surname     |
      | {(name)} | Ujna        |
      | Sonia    | {(surname)} |

  Scenario: DB rows count
    Then DB table Person row count should be = 3

    Then DB table Person row count should not be empty