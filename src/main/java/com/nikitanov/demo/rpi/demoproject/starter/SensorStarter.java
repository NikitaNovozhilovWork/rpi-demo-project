package com.nikitanov.demo.rpi.demoproject.starter;

import com.nikitanov.demo.rpi.demoproject.service.UltraSonicService;
import com.nikitanov.demo.rpi.demoproject.utils.PiJavaUltrasonic;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!mock")
public class SensorStarter implements CommandLineRunner {

  @Value("${app.sensor.ultrasonic.delay_ms:1000}")
  private int SENSOR_DELAY_MILLISECONDS = 1000;
  @Value("${app.sensor.ultrasonic.trig_pin:3}")
  private int ULTRA_SONIC_TRIG_PIN = 3; //GPIO 15
  @Value("${app.sensor.ultrasonic.echo_pin:4}")
  private int ULTRA_SONIC_ECHO_PIN = 4; //GPIO 16
  @Value("${app.sensor.ultrasonic.rejection_start_ns:1000}")
  private int ULTRA_SONIC_REJECTION_START_NS = 1000;
  @Value("${app.sensor.ultrasonic.rejection_end_ns:2147483647}")
  private int ULTRA_SONIC_REJECTION_END_NS = 2147483647;

  @Autowired
  private UltraSonicService ultraSonicService;

  @Override
  public void run(String... args) throws Exception {
    new Thread(() -> {
      PiJavaUltrasonic piJavaUltrasonic = new PiJavaUltrasonic(ULTRA_SONIC_ECHO_PIN, ULTRA_SONIC_TRIG_PIN, ULTRA_SONIC_REJECTION_START_NS, ULTRA_SONIC_REJECTION_END_NS);
      while (true) {
        ultraSonicService.setDistance(piJavaUltrasonic.getDistance());
        try {
          TimeUnit.MILLISECONDS.sleep(SENSOR_DELAY_MILLISECONDS);
        } catch (InterruptedException e) {
          e.printStackTrace();
          Thread.currentThread().interrupt();
        }
      }
    }).start();
  }

}
