package com.nikitanov.demo.rpi.demoproject.service.impl;

import com.nikitanov.demo.rpi.demoproject.service.UltraSonicService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!mock")
public class UltraSonicServiceRpiImpl implements UltraSonicService {

  private int distance_mm = 0;

  @Override
  public int getDistance() {
    synchronized (this) {
      return this.distance_mm;
    }
  }

  @Override
  public void setDistance(int distance) {
    synchronized (this) {
      this.distance_mm = distance;
    }
  }

}
