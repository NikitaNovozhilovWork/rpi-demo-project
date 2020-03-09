package com.nikitanov.demo.rpi.demoproject.service.mock;

import com.nikitanov.demo.rpi.demoproject.service.UltraSonicService;
import java.util.Random;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("mock")
public class UltraSonicServiceMockImpl implements UltraSonicService {

  private final Random random = new Random();

  @Override
  public int getDistance() {
    return random.nextInt(4001);
  }

  @Override
  public void setDistance(int distance) {

  }

}
