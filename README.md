The full documentation is at [GitHub - atdd-bdd/GherkinExecutorBase: Gherkin Executor Base translates Gherkin files into unit tests](https://github.com/atdd-bdd/GherkinExecutorForJava)

The examples.featurex file shows how it works.

To install a Gherkin Executor for your project:

- Create a new project

- Copy `Translate`into the project

- Create a `test/java `directory if it does not already exist

- Copy` starting.featurex` into the `test/java `directory

- Alter `test_framework = "JUnit5"`to whatever test framework you are using

- Execute` Translate.java` with `starting.featurex` as an argument.

You should see a directory` test/java/gherkinexecutor/Feature_Starting`

In that directory, there are four files.

- The tests are in` Feature_Starting.java  `

- You need to rename Feature_Starting_glue.tmpl to Feature_Starting_glue.java.     This is the file you will alter to call the production code.

- Run the tests in `Feature_Starting.java`

- They should all fail.   Create a temperature convertor and alter the glue code to call it. 
