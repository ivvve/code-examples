package com.tistory.devs0n.archunit.architecture

import com.tistory.devs0n.archunit.layer.persistence.IllegalDao
import com.tistory.devs0n.archunit.layer.service.MyService
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures.layeredArchitecture
import org.junit.jupiter.api.Test

@AnalyzeClasses(packages = ["com.tistory.devs0n.archunit.layer"])
class LayerDependencyTest {
    @ArchTest
    val `레이어 의존성 테스트` = layeredArchitecture()
        .layer("Controller").definedBy("..controller..")
        .layer("Service").definedBy("..service..")
        .layer("Persistence").definedBy("..persistence..")

        .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
        .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
        .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service")

        .ignoreDependency(IllegalDao::class.java, MyService::class.java)



//    @Test
//    fun layer() {
//        val rule = layeredArchitecture()
//            .layer("Controller").definedBy("..controller..")
//            .layer("Service").definedBy("..service..")
//            .layer("Persistence").definedBy("..persistence..")
//
//            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
//            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
//            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service")
//
//        val targetPackages = ClassFileImporter().importPackages("com.tistory.devs0n.archunit.layer")
//        rule.check(targetPackages)
//    }
}
