package com.dotnomi.stranded.logging;

import com.mojang.logging.LogUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;

public class LoggerConfig {
  private static final Logger LOGGER = LogUtils.getLogger();

  public static void setDebugMode(boolean enableDebugMode) {
    if (enableDebugMode) {
      Configurator.setLevel("com.dotnomi.stranded", Level.DEBUG);
      LOGGER.info("Debug mode enabled");
    } else {
      Configurator.setLevel("com.dotnomi.stranded", Level.INFO);
      LOGGER.info("Debug mode disabled");
    }
  }
}
