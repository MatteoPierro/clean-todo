# Clean Todo

This is a playground for experimenting with the concepts of the Clean Architecture.


### Running the apps

```shell
./gradlew -PmainClass=io.vocidelcodice.todo.apps.spark.SparkApp execute
```

```shell
./gradlew -PmainClass=io.vocidelcodice.todo.apps.servlet.ServletApp execute
```

#### console app

If `<a-todo-id>` is an integer id:

```shell
./gradlew assemble
java -cp app/build/libs/app.jar io.vocidelcodice.todo.apps.console.ConsoleApp <a-todo-id>
```
