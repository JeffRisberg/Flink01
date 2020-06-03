package com.company.flink01.entities;

import lombok.Data;

/** A simple alert event. */
@Data
public final class Alert {

  private long id;

  public void setId(Long id) {
    this.id = id;
  }
}
