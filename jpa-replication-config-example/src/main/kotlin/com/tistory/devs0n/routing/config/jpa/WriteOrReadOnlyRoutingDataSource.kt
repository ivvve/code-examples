package com.tistory.devs0n.routing.config.jpa

import org.slf4j.LoggerFactory
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager
import javax.sql.DataSource

open class WriteOrReadOnlyRoutingDataSource(
    writeDataSource: DataSource,
    readOnlyDataSource: DataSource,
) : AbstractRoutingDataSource() {
    init {
        super.setTargetDataSources(
            mapOf(
                RoutingType.WRITE to writeDataSource,
                RoutingType.READ_ONLY to readOnlyDataSource,
            )
        )
    }

    override fun determineCurrentLookupKey(): Any {
        val routingType =
            if (TransactionSynchronizationManager.isCurrentTransactionReadOnly())
                RoutingType.READ_ONLY
            else
                RoutingType.WRITE

        LOGGER.debug("Datasource is routed to $routingType")
        return routingType
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
