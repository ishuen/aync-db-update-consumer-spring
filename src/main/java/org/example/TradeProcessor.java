package org.example;

import org.springframework.stereotype.Component;

@Component
public class TradeProcessor {

  private StockRepository stockRepository;
  public void saveRecord(String tradeString) throws Exception {
    // [{"T":"t","S":"AAPL","i":2195,"x":"V","p":143.42,"s":100,"c":["@"],"z":"C","t":"2021-10-08T15:13:03.13396615Z"}]
    TradeRecord[] record = JsonConverter.toObject(tradeString, TradeRecord[].class);

    TradeEntity tradeEntity = new TradeEntity(record[0]);

    // save record to DB
    stockRepository.save(tradeEntity);
  }
}
