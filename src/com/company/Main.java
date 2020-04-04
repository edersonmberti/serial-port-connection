package com.company;

public class Main {
    public static void main(String[] args) {
        SerialPortController serialPortController = new SerialPortController("COM3", 9600);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        serialPortController.sendData(1);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        serialPortController.sendData(2);
    }
}
