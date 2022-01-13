package com.tistory.devs0n.enable.mongo

import org.springframework.context.annotation.Import
import org.springframework.context.annotation.ImportSelector

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(ImportSelector::class)
annotation class EnableMyMongoDBModule {
    val basePackageClasses: String
}
