package org.example;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

  @Autowired
  private TradeProcessor tradeProcessor;

  @RabbitListener(queues = {"${queue.name}"})
  public void receive(@Payload String message) {
    System.out.println("Message received: " + message);
    try {
      tradeProcessor.saveRecord(message);
    } catch (Exception e){
      System.out.println("Message Handling Error: " + e.getMessage());
    }
  }
}
