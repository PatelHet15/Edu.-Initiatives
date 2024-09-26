import java.util.*;

// Observer interface for devices
interface Observer {
    void update(String message);
}

// Subject interface for the central hub
interface Subject {
    void registerDevice(Observer device);
    void removeDevice(Observer device);
    void notifyDevices(String message);
}

// Smart Device interface
interface SmartDevice {
    void turnOn();
    void turnOff();
    String getStatus();
}

// Concrete Smart Devices
class Light implements SmartDevice, Observer {
    private int id;
    private boolean status;
    
    public Light(int id) {
        this.id = id;
        this.status = false;
    }
    
    @Override
    public void turnOn() {
        this.status = true;
        System.out.println("Light " + id + " is turned ON");
    }

    @Override
    public void turnOff() {
        this.status = false;
        System.out.println("Light " + id + " is turned OFF");
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is " + (status ? "ON" : "OFF");
    }

    @Override
    public void update(String message) {
        System.out.println("Light " + id + " received update: " + message);
    }
}

class Thermostat implements SmartDevice, Observer {
    private int id;
    private int temperature;
    
    public Thermostat(int id, int temperature) {
        this.id = id;
        this.temperature = temperature;
    }
    
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " is set to " + temperature + " degrees");
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is active.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " is off.");
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees";
    }

    @Override
    public void update(String message) {
        System.out.println("Thermostat " + id + " received update: " + message);
    }
}

class DoorLock implements SmartDevice, Observer {
    private int id;
    private boolean isLocked;
    
    public DoorLock(int id) {
        this.id = id;
        this.isLocked = true;
    }
    
    public void lock() {
        this.isLocked = true;
        System.out.println("Door " + id + " is locked");
    }

    public void unlock() {
        this.isLocked = false;
        System.out.println("Door " + id + " is unlocked");
    }

    @Override
    public void turnOn() {
        unlock();
    }

    @Override
    public void turnOff() {
        lock();
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is " + (isLocked ? "Locked" : "Unlocked");
    }

    @Override
    public void update(String message) {
        System.out.println("Door " + id + " received update: " + message);
    }
}

// Factory to create Smart Devices
class SmartDeviceFactory {
    public static SmartDevice createDevice(String type, int id) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, 22); // default temperature
            case "door":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Invalid device type");
        }
    }
}

// Proxy to control device access
class DeviceProxy implements SmartDevice {
    private SmartDevice device;

    public DeviceProxy(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void turnOn() {
        System.out.println("Accessing device...");
        device.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Accessing device...");
        device.turnOff();
    }

    @Override
    public String getStatus() {
        return device.getStatus();
    }
}

// Central Hub to manage all devices and scheduling
class CentralHub implements Subject {
    private List<Observer> devices = new ArrayList<>();
    private List<String> schedules = new ArrayList<>();
    
    @Override
    public void registerDevice(Observer device) {
        devices.add(device);
    }

    @Override
    public void removeDevice(Observer device) {
        devices.remove(device);
    }

    @Override
    public void notifyDevices(String message) {
        for (Observer device : devices) {
            device.update(message);
        }
    }
    
    public void addSchedule(String schedule) {
        schedules.add(schedule);
        System.out.println("Schedule added: " + schedule);
    }

    public void triggerAutomation(String trigger, int value) {
        if (trigger.equals("temperature") && value > 75) {
            notifyDevices("Trigger: Turn off lights");
        }
    }

    public void showStatus(List<SmartDevice> deviceList) {
        for (SmartDevice device : deviceList) {
            System.out.println(device.getStatus());
        }
    }
}

// Main program
public class SmartHomeSystem {
    public static void main(String[] args) {
        // Initialize central hub
        CentralHub hub = new CentralHub();

        // Create smart devices using Factory Pattern
        SmartDevice lightDevice = SmartDeviceFactory.createDevice("light", 1);
        SmartDevice thermostatDevice = SmartDeviceFactory.createDevice("thermostat", 2);
        SmartDevice doorDevice = SmartDeviceFactory.createDevice("door", 3);

        // Create proxies for devices
        SmartDevice lightProxy = new DeviceProxy(lightDevice);
        SmartDevice thermostatProxy = new DeviceProxy(thermostatDevice);
        SmartDevice doorProxy = new DeviceProxy(doorDevice);

        // Register actual devices to the hub (Observer Pattern)
        hub.registerDevice((Observer) lightDevice);
        hub.registerDevice((Observer) thermostatDevice);
        hub.registerDevice((Observer) doorDevice);

        // Show status of devices
        hub.showStatus(Arrays.asList(lightProxy, thermostatProxy, doorProxy));

        // Control devices through Proxy
        lightProxy.turnOn();
        thermostatProxy.turnOn();
        doorProxy.turnOff();

        // Add schedules
        hub.addSchedule("Turn on Light at 6:00 AM");

        // Trigger automation (e.g., Turn off light when temperature > 75)
        hub.triggerAutomation("temperature", 76);
    }
}
