package com.nikitanov.demo.rpi.demoproject.service.mock;

import com.nikitanov.demo.rpi.demoproject.service.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("mock")
public class ActionServiceMockImpl implements ActionService {

  public void goForward() {
    log.info("FORWARD");
  }

  public void goBackward() {
    log.info("BACKWARD");
  }

  public void turnLeft() {
    log.info("LEFT");
  }

  public void turnRight() {
    log.info("RIGHT");
  }

  public void stop() {
    log.info("STOP");
  }

}
