
import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;
    private int capacity;
    private Map<String, Vehicle> vehiclesInside;
    private List<Vehicle> history;
    private double pricePerMinute = 1.5;

    private ParkingLot(int capacity) {
        this.capacity = capacity;
        vehiclesInside = new HashMap<>();
        history = new ArrayList<>();
    }

    public static ParkingLot getInstance(int capacity) {
        if (instance == null) {
            instance = new ParkingLot(capacity);
        }
        return instance;
    }

    public boolean enterParking(Vehicle v) {
        if (vehiclesInside.size() >= capacity) {
            System.out.println("החניון מלא.");
            return false;
        }
        if (!vehiclesInside.containsKey(v.getPlateNumber())) {
            v.enter();
            vehiclesInside.put(v.getPlateNumber(), v);
            return true;
        }
        return false;
    }

    public boolean exitParking(String plate) {
        Vehicle v = vehiclesInside.remove(plate);
        if (v != null) {
            v.exit();
            history.add(v);
            System.out.println("רכב יצא, עלות: " + calculateCost(v) + " ש"ח");
            return true;
        }
        return false;
    }

    public double calculateCost(Vehicle v) {
        return v.getParkingDurationMinutes() * pricePerMinute;
    }

    public String getStatisticsReport() {
        double total = 0;
        double avgTime = 0;
        if (history.size() > 0) {
            for (Vehicle v : history) {
                total += calculateCost(v);
                avgTime += v.getParkingDurationMinutes();
            }
            avgTime /= history.size();
        }
        return "סה"כ רכבים: " + history.size() +
                "\nממוצע זמן חניה: " + avgTime +
                "\nרווח כולל: " + total + " ש"ח";
    }
}
