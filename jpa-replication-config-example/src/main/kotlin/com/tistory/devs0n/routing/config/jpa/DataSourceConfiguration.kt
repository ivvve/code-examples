package com.tistory.devs0n.routing.config.jpa

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableAutoConfiguration(
    exclude = [
        DataSourceAutoConfiguration::class,
    ]
)
@EnableTransactionManagement
class DataSourceConfiguration {
    @Bean(name = ["writeDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.write.hikari")
    fun writeDataSource(): DataSource {
        return HikariDataSource()
    }

    @Bean(name = ["readOnlyDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.read-only.hikari")
    fun readOnlyDataSource(): DataSource {
        return HikariDataSource()
    }

    @Bean(name = ["routingDataSource"])
    fun routingDataSource(
        @Qualifier("writeDataSource") writeDataSource: DataSource,
        @Qualifier("readOnlyDataSource") readOnlyDataSource: DataSource,
    ): DataSource {
        // Custom Routing DataSource
        return WriteOrReadOnlyRoutingDataSource(writeDataSource, readOnlyDataSource)
    }

    @Primary
    @Bean(name = ["dataSource"])
    fun dataSource(
        @Qualifier("routingDataSource") routingDataSource: DataSource,
    ): LazyConnectionDataSourceProxy {
        return LazyConnectionDataSourceProxy(routingDataSource)
    }

//    @Primary
//    @Bean(name = ["dataSource"])
//    fun dataSource(
//        @Qualifier("writeDataSource") writeDataSource: DataSource,
//        @Qualifier("readOnlyDataSource") readOnlyDataSource: DataSource,
//    ): DataSource {
//        // Custom Routing DataSource
//        return WriteOrReadOnlyRoutingDataSource(writeDataSource, readOnlyDataSource)
//    }
}
