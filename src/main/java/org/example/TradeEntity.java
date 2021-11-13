package org.example;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
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

  public TradeEntity(TradeRecord tradeRecord){
    this.tradeId = tradeRecord.getId();
    this.exchangeCode = tradeRecord.getExchangeCode();
    this.symbol = tradeRecord.getSymbol();
    this.price = tradeRecord.getPrice();
    this.quantity = tradeRecord.getSize();
    this.updateTime = tradeRecord.getTimestamp();
  }
}
