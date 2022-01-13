package com.tistory.devs0n.enable.mongo.config

import com.tistory.devs0n.enable.mongo.EnableMyMongoDBModule
import org.springframework.context.annotation.ImportSelector
import org.springframework.core.type.AnnotationMetadata

class MyMongoDBModuleImportSelector : ImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val annotationMetaData = importingClassMetadata.getAnnotationAttributes(EnableMyMongoDBModule::class.java.name)
        // EnableMyMongoDBModule를 사용하여 Import 조건 처리
        return arrayOf(MyMongoDBConfiguration::class.java.name)
    }
}
