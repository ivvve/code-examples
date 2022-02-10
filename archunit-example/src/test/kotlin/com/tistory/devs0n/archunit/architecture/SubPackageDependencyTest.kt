package com.tistory.devs0n.archunit.architecture

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.junit.AnalyzeClasses
import org.junit.jupiter.api.Test

@AnalyzeClasses(packages = ["com.tistory.devs0n.archunit.subpackage"])
class SubPackageDependencyTest {
//    @ArchTest
//    val `패키지 의존성은 하위 패키지만 가질 수 있다` = classes()
//        .should().dependOnClassesThat().resideInAPackage()

    @Test
    fun aa() {
        val targetClasses = ClassFileImporter().importPackages("com.tistory.devs0n.archunit.subpackage")

        for (klass in targetClasses) {
//            println(klass.directDependenciesToSelf)
//            println("00")
//
//            if (klass.accessesToSelf.isEmpty()) {
//                continue
//            }
//
//
//
//            klass.accessesToSelf.forEach {
//                val origin = it.origin.owner.`package`
//                val target = it.target.owner.`package`
//            }
//
//
            if (klass.accessesToSelf.isEmpty()) continue

            println("===")
            println(klass.name)
            klass.accessesToSelf.forEach {
                println(it)
            }
//            klass.directDependenciesToSelf.forEach { println(it) } // 자기가 레퍼런스 하는건 동일 패키지 혹은 하위 패키지
            println("===")
        }
    }
}
