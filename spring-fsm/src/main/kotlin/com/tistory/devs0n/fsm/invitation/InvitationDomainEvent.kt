package com.tistory.devs0n.fsm.invitation

sealed class InvitationDomainEvent(
    open val invitationId: Invitation.Id
) {
    data class InvitationSent(
        override val invitationId: Invitation.Id,
    ) : InvitationDomainEvent(invitationId)

    data class InvitationAccepted(
        override val invitationId: Invitation.Id,
    ) : InvitationDomainEvent(invitationId)

    data class InvitationRejected(
        override val invitationId: Invitation.Id,
    ) : InvitationDomainEvent(invitationId)

    data class InvitationCanceled(
        override val invitationId: Invitation.Id,
    ) : InvitationDomainEvent(invitationId)

    data class InvitationUsed(
        override val invitationId: Invitation.Id,
    ) : InvitationDomainEvent(invitationId)
}

enum class InvitationEvent {
    SENT,
    ACCEPTED,
    REJECTED,
    CANCELED,
    USED,
}
