
public class ParkingLotTest {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance(2);

        Vehicle car1 = VehicleFactory.createVehicle("1111111", "Ford");
        Vehicle car2 = VehicleFactory.createVehicle("2222222", "Opel");

        lot.enterParking(car1);
        lot.enterParking(car2);

        try {
            Thread.sleep(1000); // שינה 1 שניה
        } catch (InterruptedException e) {}

        lot.exitParking("1111111");
        lot.exitParking("2222222");

        System.out.println("בדיקת סטטיסטיקה:");
        System.out.println(lot.getStatisticsReport());
    }
}
