package org.example;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
  private final static String QUEUE_NAME = "queue";

  @RabbitListener(queues = QUEUE_NAME)
  public void listen(String text) {
    System.out.println("Message read from myQueue : " + text);
  }
}
