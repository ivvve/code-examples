package com.tistory.devs0n.amd.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.TransactionManager
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(
    basePackages = ["com.tistory.devs0n.amd.domain.member"],
    entityManagerFactoryRef = "memberEntityManagerFactoryBean",
    transactionManagerRef = "memberTransactionManager",
)
class MemberDataSourceConfig {

    @Primary
    @Bean(name = ["memberDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.member.hikari")
    fun memberDataSource(): DataSource {
        return DataSourceBuilder.create()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Primary
    @Bean(name = ["memberEntityManagerFactoryBean"])
    fun memberEntityManagerFactoryBean(
        @Qualifier("memberDataSource") dataSource: DataSource,
        jpaProperties: JpaProperties,
        hibernateProperties: HibernateProperties,
    ): LocalContainerEntityManagerFactoryBean {
        val entityManagerFactoryBean = LocalContainerEntityManagerFactoryBean()
        entityManagerFactoryBean.dataSource = dataSource
        entityManagerFactoryBean.setPackagesToScan("com.tistory.devs0n.amd.domain.member")
        entityManagerFactoryBean.jpaVendorAdapter = HibernateJpaVendorAdapter()
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties.properties(hibernateProperties))
        return entityManagerFactoryBean
    }

    @Primary
    @Bean(name = ["memberTransactionManager"])
    fun memberTransactionManager(
        @Qualifier("memberEntityManagerFactoryBean") entityManagerFactory: LocalContainerEntityManagerFactoryBean
    ): TransactionManager {
        return JpaTransactionManager(entityManagerFactory.`object`!!)
    }
}
