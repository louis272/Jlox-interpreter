plugins {
    application
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.craftinginterpreters.lox.Lox")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

// Chapter 5: regenerate Expr.java / Stmt.java
tasks.register<JavaExec>("generateAst") {
    group = "lox"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("com.craftinginterpreters.tool.GenerateAst")
    args("src/main/java/com/craftinginterpreters/lox")
}