package com.company.flink01.sinks;

import com.company.flink01.entities.Alert;
import org.apache.flink.annotation.PublicEvolving;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A sink for outputting alerts.
 */
@PublicEvolving
@SuppressWarnings("unused")
public class AlertSink implements SinkFunction<Alert> {

  private static final long serialVersionUID = 1L;

  private static final Logger LOG = LoggerFactory.getLogger(AlertSink.class);

  @Override
  public void invoke(Alert value, Context context) {
    LOG.info(value.toString());
  }
}
