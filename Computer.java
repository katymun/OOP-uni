/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1;

/**
 *
 * @author munka
 */
public class Computer {
    private String brand;
    private String model;
    private String processor;
    private int ram;
    private String storage;
    private String operatingSystem;
    private double price;

    public Computer(String brand, String model, String processor, int ram, String storage, String operatingSystem, double price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }

    public void start() {
        System.out.println("Computer started.");
    }

    public void shutdown() {
        System.out.println("Computer shut down.");
    }

    public void restart() {
        System.out.println("Computer restarted.");
    }

    public void sleep() {
        System.out.println("Computer went to sleep.");
    }

    public void upgradeRAM(int additionalRAM) {
        this.ram += additionalRAM;
        System.out.println("RAM upgraded to " + this.ram + "GB.");
    }

    public void upgradeStorage(String newStorage) {
        this.storage = newStorage;
        System.out.println("Storage upgraded to " + this.storage + ".");
    }

    public void installSoftware(String softwareName) {
        System.out.println("Installed " + softwareName + " software.");
    }

    public void runApplication(String appName) {
        System.out.println("Running " + appName + ".");
    }

    public void checkStatus() {
        System.out.println("Computer Status:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("Storage: " + storage);
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("Price: $" + price);
    }
}

