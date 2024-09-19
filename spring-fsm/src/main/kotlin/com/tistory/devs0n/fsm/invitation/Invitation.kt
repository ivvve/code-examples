package com.tistory.devs0n.fsm.invitation

class Invitation(
    id: Id,
    status: InvitationStatus,
    senderUserId: SenderUserId,
    receiverUserId: ReceiverUserId,
) {
    val id: Id = id
    val status: InvitationStatus = status
    val senderUserId: SenderUserId = senderUserId
    val receiverUserId: ReceiverUserId = receiverUserId

    @JvmInline
    value class Id(
        val value: String,
    )

    @JvmInline
    value class SenderUserId(
        val value: String,
    )

    @JvmInline
    value class ReceiverUserId(
        val value: String,
    )
}
