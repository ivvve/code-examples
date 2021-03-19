package io.github.ivvve.multids.first

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

private const val CONFIGURATION_PROPERTIES = "spring.datasource.first"
private const val BASE_PACKAGE = "io.github.ivvve.multids.first"

private const val DATA_SOURCE_PROPERTIES_BEAN = "firstDataSourceProperties"
private const val DATA_SOURCE_BEAN = "firstDataSource"
private const val ENTITY_MANAGER_FACTORY_BEAN = "firstEntityManagerFactory"
private const val TRANSACTION_MANAGER_BEAN = "firstTransactionManager"


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = ENTITY_MANAGER_FACTORY_BEAN,
    transactionManagerRef = TRANSACTION_MANAGER_BEAN,
    basePackages = [BASE_PACKAGE]
)
class FirstDataSourceConfig(
    @Value("\${$CONFIGURATION_PROPERTIES.ddl-auto}") private val ddlAuto: String,
) {

    @Primary
    @Bean(name = [DATA_SOURCE_PROPERTIES_BEAN])
    @ConfigurationProperties(CONFIGURATION_PROPERTIES)
    fun firstDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties();
    }

    @Primary
    @Bean(name = [DATA_SOURCE_BEAN])
    @ConfigurationProperties("${CONFIGURATION_PROPERTIES}.configuration")
    fun firstDataSource(
        @Qualifier(DATA_SOURCE_PROPERTIES_BEAN) firstDataSourceProperties: DataSourceProperties
    ): DataSource {
        return firstDataSourceProperties.initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Primary
    @Bean(name = [ENTITY_MANAGER_FACTORY_BEAN])
    fun firstEntityManagerFactory(
        firstEntityManagerFactoryBuilder: EntityManagerFactoryBuilder,
        @Qualifier(DATA_SOURCE_BEAN) firstDataSource: DataSource
    ): LocalContainerEntityManagerFactoryBean {
        val firstJpaProperties = mapOf(
            Pair("hibernate.hbm2ddl.auto", ddlAuto)
        )

        return firstEntityManagerFactoryBuilder
            .dataSource(firstDataSource)
            .packages(BASE_PACKAGE)
            .persistenceUnit(DATA_SOURCE_BEAN)
            .properties(firstJpaProperties)
            .build()
    }

    @Primary
    @Bean(name = [TRANSACTION_MANAGER_BEAN])
    fun primaryTransactionManager(
        @Qualifier(ENTITY_MANAGER_FACTORY_BEAN) primaryEntityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(primaryEntityManagerFactory);
    }
}
