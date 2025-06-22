
public class Main {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance(50); // חניון עם 50 מקומות

        Vehicle v1 = VehicleFactory.createVehicle("1234567", "Toyota");
        Vehicle v2 = VehicleFactory.createVehicle("7654321", "Mazda");

        lot.enterParking(v1);
        lot.enterParking(v2);

        try {
            Thread.sleep(3000); // חנייה של 3 שניות
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lot.exitParking(v1.getPlateNumber());

        System.out.println("דו"ח סטטיסטיקה:");
        System.out.println(lot.getStatisticsReport());

        System.out.println("שכפול רכב:");
        Vehicle clone = v1.clone();
        System.out.println(clone);
    }
}
