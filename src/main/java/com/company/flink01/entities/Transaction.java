package com.company.flink01.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * A simple transaction.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Transaction {

  private long accountId;

  private long timestamp;

  private double amount;

  public long getAccountId() {
    return accountId;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
