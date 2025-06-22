
import java.time.LocalDateTime;

public class Vehicle implements Cloneable {
    private String plateNumber;
    private String model;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Vehicle(String plateNumber, String model) {
        this.plateNumber = plateNumber;
        this.model = model;
    }

    public void enter() {
        this.entryTime = LocalDateTime.now();
    }

    public void exit() {
        this.exitTime = LocalDateTime.now();
    }

    public double getParkingDurationMinutes() {
        if (entryTime != null && exitTime != null) {
            return java.time.Duration.between(entryTime, exitTime).toMinutes();
        }
        return 0;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    @Override
    public Vehicle clone() {
        return new Vehicle(this.plateNumber + "_copy", this.model);
    }

    @Override
    public String toString() {
        return "רכב מס'" + plateNumber + " דגם: " + model;
    }
}
