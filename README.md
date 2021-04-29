# Clean Todo

This is a playground for experimenting with the concepts of the Clean Architecture.


## Running the apps

### Spark app
```shell
./gradlew -PmainClass=io.vocidelcodice.todo.apps.spark.SparkApp execute
```

### Servlet app

```shell
./gradlew -PmainClass=io.vocidelcodice.todo.apps.servlet.ServletApp execute
```

### Console app

If `<a-todo-id>` is an integer id:

```shell
./gradlew assemble
java -cp app/build/libs/app.jar io.vocidelcodice.todo.apps.console.ConsoleApp <a-todo-id>
```
