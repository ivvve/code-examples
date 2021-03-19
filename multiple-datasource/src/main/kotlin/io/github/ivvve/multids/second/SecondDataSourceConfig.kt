package io.github.ivvve.multids.second

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

private const val CONFIGURATION_PROPERTIES = "spring.datasource.second"
private const val BASE_PACKAGE = "io.github.ivvve.multids.second"

private const val DATA_SOURCE_PROPERTIES_BEAN = "secondDataSourceProperties"
private const val DATA_SOURCE_BEAN = "secondDataSource"
private const val ENTITY_MANAGER_FACTORY_BEAN = "secondEntityManagerFactory"
private const val TRANSACTION_MANAGER_BEAN = "secondTransactionManager"


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = ENTITY_MANAGER_FACTORY_BEAN,
    transactionManagerRef = TRANSACTION_MANAGER_BEAN,
    basePackages = [BASE_PACKAGE]
)
class SecondDataSourceConfig(
    @Value("\${$CONFIGURATION_PROPERTIES.ddl-auto}") private val ddlAuto: String,
) {

    @Bean(name = [DATA_SOURCE_PROPERTIES_BEAN])
    @ConfigurationProperties(CONFIGURATION_PROPERTIES)
    fun firstDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties();
    }

    @Bean(name = [DATA_SOURCE_BEAN])
    @ConfigurationProperties("${CONFIGURATION_PROPERTIES}.configuration")
    fun secondDataSource(
        @Qualifier(DATA_SOURCE_PROPERTIES_BEAN) secondDataSourceProperties: DataSourceProperties
    ): DataSource {
        return secondDataSourceProperties.initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean(name = [ENTITY_MANAGER_FACTORY_BEAN])
    fun secondEntityManagerFactory(
        secondEntityManagerFactoryBuilder: EntityManagerFactoryBuilder,
        @Qualifier(DATA_SOURCE_BEAN) secondDataSource: DataSource
    ): LocalContainerEntityManagerFactoryBean {
        val secondJpaProperties = mapOf(
            Pair("hibernate.hbm2ddl.auto", ddlAuto)
        )

        return secondEntityManagerFactoryBuilder
            .dataSource(secondDataSource)
            .packages(BASE_PACKAGE)
            .persistenceUnit(DATA_SOURCE_BEAN)
            .properties(secondJpaProperties)
            .build()
    }

    @Bean(name = [TRANSACTION_MANAGER_BEAN])
    fun primaryTransactionManager(
        @Qualifier(ENTITY_MANAGER_FACTORY_BEAN) primaryEntityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(primaryEntityManagerFactory);
    }
}
