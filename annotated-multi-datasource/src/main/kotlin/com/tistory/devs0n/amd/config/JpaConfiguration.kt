package com.tistory.devs0n.amd.config

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
class JpaConfiguration {
    @ConfigurationProperties(prefix = "spring.jpa")
    fun JpaProperties(): JpaProperties {
        return JpaProperties()
    }

    @ConfigurationProperties(prefix = "spring.jpa.hibernate")
    fun hibernateProperties(): HibernateProperties {
        return HibernateProperties()
    }
}

fun JpaProperties.properties(hibernateProperties: HibernateProperties): Map<String, Any> {
    val properties: MutableMap<String, Any> = HashMap(this.properties)
    properties["hibernate.show_sql"] = this.isShowSql
    properties["hibernate.hbm2ddl.auto"] = hibernateProperties.ddlAuto
    return properties
}
