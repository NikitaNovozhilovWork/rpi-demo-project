package com.nikitanov.demo.rpi.demoproject.service.impl;

import com.nikitanov.demo.rpi.demoproject.service.ActionService;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!mock")
public class ActionServiceRpiImpl implements ActionService {

  private final GpioPinDigitalOutput pin01;
  private final GpioPinDigitalOutput pin02;
  private final GpioPinDigitalOutput pin03;
  private final GpioPinDigitalOutput pin04;

  public ActionServiceRpiImpl() {
    final GpioController gpio = GpioFactory.getInstance();
    pin01 = initializePin(RaspiPin.GPIO_22, "LeftEngineForward", gpio);
    pin02 = initializePin(RaspiPin.GPIO_23, "LeftEngineBackward", gpio);
    pin03 = initializePin(RaspiPin.GPIO_24, "RightEngineForward", gpio);
    pin04 = initializePin(RaspiPin.GPIO_25, "RightEngineBackward", gpio);
  }

  private static GpioPinDigitalOutput initializePin(Pin raspiPin, String pinName, GpioController gpio) {
    GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(raspiPin, pinName, PinState.LOW);
    pin.setShutdownOptions(true, PinState.LOW);
    return pin;
  }

  public void goForward() {
    pin02.low();
    pin04.low();
    pin01.high();
    pin03.high();
  }

  public void goBackward() {
    pin01.low();
    pin03.low();
    pin02.high();
    pin04.high();
  }

  public void turnLeft() {
    pin01.low();
    pin04.low();
    pin02.high();
    pin03.high();
  }

  public void turnRight() {
    pin02.low();
    pin03.low();
    pin01.high();
    pin04.high();
  }

  public void stop() {
    pin01.low();
    pin02.low();
    pin03.low();
    pin04.low();
  }

}
