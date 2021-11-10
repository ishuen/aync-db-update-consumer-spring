package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="trade_data")
public class TradeEntity {
  @Id
  @Column(name = "trade_id")
  private long tradeId;

  private String symbol;

  @Column(name = "exchange_code")
  private String exchangeCode;

  private double price;

  private int quantity;

  private Timestamp updateTime;
}
