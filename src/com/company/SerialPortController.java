package com.company;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.OutputStream;

public class SerialPortController {
  private OutputStream serialOut;
  private String serialPort;
  private int rate;

  public SerialPortController(String serialPort, int rate) {
    this.serialPort = serialPort;
    this.rate = rate;

    this.initialize();
  }

  private void initialize() {
    try {
      CommPortIdentifier portId = null;

      try {
        portId = CommPortIdentifier.getPortIdentifier(this.serialPort);
      }catch (Exception e) {
        e.printStackTrace();
      }

      SerialPort port = (SerialPort) portId.open("Serial communication", this.rate);
      serialOut = port.getOutputStream();
      port.setSerialPortParams(this.rate,
              SerialPort.DATABITS_8,
              SerialPort.STOPBITS_1,
              SerialPort.PARITY_NONE);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      serialOut.close();

      System.out.println("Successfully closed port");
    }catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void sendData(int data){
    try {
      serialOut.write(data);

      System.out.println("Successfully sent data: " + data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
