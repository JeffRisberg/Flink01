package com.company.flink01;

import com.company.flink01.entities.Alert;
import com.company.flink01.entities.Transaction;
import com.company.flink01.sinks.AlertSink;
import com.company.flink01.sources.TransactionSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FraudDetectionJob {

  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    DataStream<Transaction> transactions = env
      .addSource(new TransactionSource())
      .name("transactions");

    DataStream<Alert> alerts = transactions
      .keyBy(Transaction::getAccountId)
      .process(new FraudDetector())
      .name("fraud-detector");

    alerts
      .addSink(new AlertSink())
      .name("send-alerts");

    env.execute("Fraud Detection");
  }
}
