package com.nikitanov.demo.rpi.demoproject.controller;

import com.nikitanov.demo.rpi.demoproject.service.UltraSonicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

  @Autowired
  private UltraSonicService ultraSonicService;

  @GetMapping("/distance")
  public double getUltraSonicDistance() {
    return ultraSonicService.getDistance();
  }

}
