package com.nikitanov.demo.rpi.demoproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action")
public class RestActionController {

  @RequestMapping("/go")
  public void go() {

  }

  @RequestMapping("/stop")
  public void stop() {

  }

}
