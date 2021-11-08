package org.example;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
  private final static String QUEUE_NAME = "queue";
  private final static boolean NON_DURABLE = false;
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Queue queue() {
    return new Queue(QUEUE_NAME, NON_DURABLE);
  }

  @RabbitListener(queues = QUEUE_NAME)
  public void listen(String text) {
    System.out.println("Message read from myQueue : " + text);
  }
}
