package com.tistory.devs0n.jooq.order

import com.tistory.devs0n.jooq.models.tables.Orders.Companion.ORDERS
import com.tistory.devs0n.jooq.models.tables.records.OrderLinesRecord
import com.tistory.devs0n.jooq.models.tables.records.OrdersRecord
import com.tistory.devs0n.jooq.models.tables.references.ORDER_LINES
import org.jooq.DSLContext
import org.jooq.Result
import org.jooq.impl.DSL
import org.jooq.impl.DSL.currentLocalDateTime
import org.jooq.types.UInteger
import org.jooq.types.ULong
import org.springframework.stereotype.Repository

@Repository
class OrderRepository(
    private val dsl: DSLContext,
) {
    fun insert(order: Order): Order {
        val orderRecord = this.insertOrder(order)
        val orderLineRecords = this.insertOrderLines(orderRecord = orderRecord, orderLines = order.orderLines)
        return orderRecord.toOrder(orderLineRecords)
    }

    private fun insertOrder(order: Order): OrdersRecord {
        return this.dsl.insertInto(ORDERS)
            .set(ORDERS.USER_ID, ULong.valueOf(order.userId))
            .set(ORDERS.TOTAL_PRICE, order.totalPrice)
            .set(ORDERS.CREATED_AT, currentLocalDateTime())
            .set(ORDERS.UPDATED_AT, currentLocalDateTime())
            .returning()
            .fetchOne()!!
    }

    private fun insertOrderLines(orderRecord: OrdersRecord, orderLines: List<OrderLine>): Result<OrderLinesRecord> {
        var orderLineInsertStatement = this.dsl.insertInto(ORDER_LINES)
            .columns(
                ORDER_LINES.ORDER_ID,
                ORDER_LINES.PRODUCT_ID,
                ORDER_LINES.QUANTITY,
                ORDER_LINES.UNIT_PRICE,
                ORDER_LINES.CREATED_AT,
                ORDER_LINES.UPDATED_AT,
            )

        for (orderLine in orderLines) {
            orderLineInsertStatement = orderLineInsertStatement.values(
                DSL.value(orderRecord.id),
                DSL.value(ULong.valueOf(orderLine.productId)),
                DSL.value(UInteger.valueOf(orderLine.quantity)),
                DSL.value(orderLine.unitPrice),
                currentLocalDateTime(),
                currentLocalDateTime(),
            )
        }

        return orderLineInsertStatement
            .returning()
            .fetch()
    }

    fun update(order: Order): Order {
        require(order.id != null)
        val orderRecord = this.updateOrder(order)
        val orderLineRecords = this.updateOrderLines(orderRecord = orderRecord, orderLines = order.orderLines)
        return orderRecord.toOrder(orderLineRecords)
    }

    private fun updateOrder(order: Order): OrdersRecord {
        // update
        this.dsl.update(ORDERS)
            .set(ORDERS.USER_ID, ULong.valueOf(order.userId))
            .set(ORDERS.TOTAL_PRICE, order.totalPrice)
            .set(ORDERS.UPDATED_AT, currentLocalDateTime())
            .where(ORDERS.ID.eq(ULong.valueOf(order.id!!)))
            .execute()

        // select
        // MySQL은 update에 returning을 지원하지 않음 - [참고](https://www.jooq.org/doc/latest/manual/sql-building/sql-statements/update-statement/update-returning/)
        return this.dsl.selectFrom(ORDERS)
            .where(ORDERS.ID.eq(ULong.valueOf(order.id)))
            .fetchOne()!!
    }

    private fun updateOrderLines(orderRecord: OrdersRecord, orderLines: List<OrderLine>): Result<OrderLinesRecord> {
        // delete
        this.dsl.deleteFrom(ORDER_LINES)
            .where(ORDER_LINES.ORDER_ID.eq(orderRecord.id))
            .execute()

        return this.insertOrderLines(orderRecord, orderLines)
    }
}

private fun OrdersRecord.toOrder(orderLineRecords: Result<OrderLinesRecord>): Order {
    return Order(
        id = this.id!!.toLong(),
        userId = this.userId!!.toLong(),
        orderLines = orderLineRecords.map { it.toOrderLine() },
        totalPrice = this.totalPrice!!,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
}

private fun OrderLinesRecord.toOrderLine(): OrderLine {
    return OrderLine(
        id = this.id!!.toLong(),
        productId = this.productId!!.toLong(),
        quantity = this.quantity!!.toInt(),
        unitPrice = this.unitPrice!!,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
}
