package com.example.demo.turnstile.domain;

import com.akkaserverless.javasdk.testkit.ValueEntityResult;
import com.akkaserverless.javasdk.valueentity.ValueEntity;
import com.example.demo.turnstile.TurnstileApi;
import com.google.protobuf.Empty;
import org.junit.Test;

import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class TurnstileTest {

  @Test
  public void exampleTest() {
    TurnstileTestKit testKit = TurnstileTestKit.of(Turnstile::new);
    // use the testkit to execute a command
    // of events emitted, or a final updated state:
    // ValueEntityResult<SomeResponse> result = testKit.someOperation(SomeRequest);
    // verify the response
    // SomeResponse actualResponse = result.getReply();
    // assertEquals(expectedResponse, actualResponse);
    // verify the final state after the command
    // assertEquals(expectedState, testKit.getState());
  }

  @Test
  public void pushTest() {
    TurnstileTestKit testKit = TurnstileTestKit.of(Turnstile::new);
    // ValueEntityResult<Empty> result = testKit.push(PushCommand.newBuilder()...build());
  }


  @Test
  public void coinTest() {
    TurnstileTestKit testKit = TurnstileTestKit.of(Turnstile::new);
    // ValueEntityResult<Empty> result = testKit.coin(CoinCommand.newBuilder()...build());
  }


  @Test
  public void getCurrentTurnstileTest() {
    TurnstileTestKit testKit = TurnstileTestKit.of(Turnstile::new);
    // ValueEntityResult<TurnstileState> result = testKit.getCurrentTurnstile(GetTurnstile.newBuilder()...build());
  }

}
