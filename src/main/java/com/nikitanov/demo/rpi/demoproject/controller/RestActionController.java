package com.nikitanov.demo.rpi.demoproject.controller;

import com.nikitanov.demo.rpi.demoproject.model.Direction;
import com.nikitanov.demo.rpi.demoproject.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action")
public class RestActionController {

  @Autowired
  private ActionService actionService;

  @RequestMapping("/move")
  public void move(@RequestParam("name") Direction direction) {
    switch (direction) {
      case FORWARD:
        actionService.goForward();
        break;
      case RIGHT:
        actionService.turnRight();
        break;
      case LEFT:
        actionService.turnLeft();
        break;
      case BACKWARD:
        actionService.goBackward();
        break;
      default:
        throw new RuntimeException("Impossible direction - " + direction);
    }
  }

  @RequestMapping("/stop")
  public void stop() {
    actionService.stop();
  }

}
