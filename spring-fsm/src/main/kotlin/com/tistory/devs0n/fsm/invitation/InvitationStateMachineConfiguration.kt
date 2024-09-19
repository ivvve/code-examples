package com.tistory.devs0n.fsm.invitation

import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.action.Action
import org.springframework.statemachine.config.EnableStateMachine
import org.springframework.statemachine.config.EnableStateMachineFactory
import org.springframework.statemachine.config.StateMachineConfigurerAdapter
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer

@Configuration
@EnableStateMachine
@EnableStateMachineFactory
class InvitationStateMachineConfiguration
    : StateMachineConfigurerAdapter<InvitationStatus, InvitationEvent>() {

    override fun configure(states: StateMachineStateConfigurer<InvitationStatus, InvitationEvent>) {
        states
            .withStates()
            .initial(InvitationStatus.WAITING)
            .states(
                setOf(
                    InvitationStatus.ACCEPTED,
                )
            )
            .end(InvitationStatus.CANCELED)
            .end(InvitationStatus.REJECTED)
            .end(InvitationStatus.USED)
    }

    override fun configure(transitions: StateMachineTransitionConfigurer<InvitationStatus, InvitationEvent>) {
        transitions
            .withExternal()
            .source(InvitationStatus.WAITING)
            .target(InvitationStatus.ACCEPTED)
            .event(InvitationEvent.ACCEPTED)
            .action(this.logTransition())
            .and()
            .withExternal()
            .source(InvitationStatus.WAITING)
            .target(InvitationStatus.CANCELED)
            .event(InvitationEvent.CANCELED)
            .action(this.logTransition())
            .and()
            .withExternal()
            .source(InvitationStatus.WAITING)
            .target(InvitationStatus.REJECTED)
            .event(InvitationEvent.REJECTED)
            .action(this.logTransition())
            .and()
            .withExternal()
            .source(InvitationStatus.ACCEPTED)
            .source(InvitationStatus.USED)
            .event(InvitationEvent.USED)
            .action(this.logTransition())
    }

    private fun logTransition(): Action<InvitationStatus, InvitationEvent> {
        return Action {
            println("source: ${it.source} => target: ${it.target}")
        }
    }
}
