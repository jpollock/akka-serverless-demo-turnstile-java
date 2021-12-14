package com.example.demo.turnstile.domain;

import com.akkaserverless.javasdk.valueentity.ValueEntityContext;
import com.example.demo.turnstile.TurnstileApi;
import com.google.protobuf.Empty;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

/** A value entity. */
public class Turnstile extends AbstractTurnstile {
  @SuppressWarnings("unused")
  private final String entityId;

  public Turnstile(ValueEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public TurnstileDomain.TurnstileState emptyState() {
    return TurnstileDomain.TurnstileState.getDefaultInstance();
  }

  @Override
  public Effect<TurnstileDomain.TurnstileState> handleEvent(TurnstileDomain.TurnstileState currentState, TurnstileApi.StateChangeCommand stateChangeCommand) {
    System.out.println("Turnstile.handleEvent: " + stateChangeCommand.getTurnstileId());
    System.out.println("Current state: " + currentState);
    if ( currentState != emptyState() &&
        (currentState.getStatus().equals(TurnstileDomain.TurnstileState.Status.LOCKED) && stateChangeCommand.getEvent().equals(TurnstileApi.StateChangeCommand.Event.PUSHED))
        || (currentState.getStatus().equals(TurnstileDomain.TurnstileState.Status.UNLOCKED) && stateChangeCommand.getEvent().equals(TurnstileApi.StateChangeCommand.Event.COINED)))
        {
          System.out.println("ALREADY");
      return effects()
        .reply(currentState);
    } else if (stateChangeCommand.getEvent().equals(TurnstileApi.StateChangeCommand.Event.PUSHED)) {
      TurnstileDomain.TurnstileState newState =  
        currentState.toBuilder()
          .setTurnstileId(stateChangeCommand.getTurnstileId())
          .setStatus(TurnstileDomain.TurnstileState.Status.LOCKED)
          .build();
      System.out.println("PUSHED");
      return effects()
        .updateState(newState) 
        .thenReply(newState);
    } else if (stateChangeCommand.getEvent().equals(TurnstileApi.StateChangeCommand.Event.COINED)) {
      TurnstileDomain.TurnstileState newState =  
        currentState.toBuilder()
          .setTurnstileId(stateChangeCommand.getTurnstileId())
          .setStatus(TurnstileDomain.TurnstileState.Status.UNLOCKED)
          .build();
      System.out.println("COINED");
      return effects()
        .updateState(newState) 
        .thenReply(newState);
    } else {
      System.out.println("HOW");
      return effects()
        .reply(emptyState());
    }
  }

  @Override
  public Effect<TurnstileDomain.TurnstileState> getCurrentTurnstile(TurnstileDomain.TurnstileState currentState, TurnstileApi.GetTurnstile getTurnstile) {
    return effects().reply(currentState);
  }
}
