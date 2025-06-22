
public class VehicleFactory {
    public static Vehicle createVehicle(String plate, String model) {
        return new Vehicle(plate, model);
    }
}
