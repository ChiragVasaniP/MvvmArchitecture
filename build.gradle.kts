// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript{
    val objectboxVersion by extra("3.7.1") // For KTS build scripts

    dependencies{
        classpath("io.objectbox:objectbox-gradle-plugin:$objectboxVersion")
    }
}



plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}