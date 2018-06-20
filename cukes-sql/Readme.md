#Cukes SQL

**Cukes SQL** is an extension to cukes framework that allows simplified testing of data stored in DB

##Sample Step

**Cukes SQL** support exact matching with Table values

```gherkin
Then DB table Person should match:
       | id | name  | surname | age |
       | 1  | Anju  | Ujna    | 5   |
       | 2  | Sonia | Ainos   | 19  |
       | 3  | Asha  | Tear    | 35  |
```

And can check whether target Table contains subset of values

```gherkin
And DB table Person should contain:
      | name  | age |
      | Anju  | 5   |
      | Sonia | 19  |
```

Also **Cukes SQL** can be used with ContextInflater

```gherkin
Then DB table Person should match:
      | id | name     | surname     | age |
      | 1  | {(name)} | Ujna        | 5   |
      | 2  | Sonia    | {(surname)} | 19  |
      | 3  | Asha     | Tear        | 35  |
```
 
It is possible to check content of the Table without using exact values to compare
 
```gherkin
Then DB table Person row count should be = 3
```
 
```gherkin
Then DB table Person row count should not be empty
```
 
## Prerequisites

- Java-based project
- Java 1.8
- Maven or Gradle as build system