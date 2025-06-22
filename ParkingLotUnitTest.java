/**
 * בדיקות פשוטות עבור ParkingLot ו-Vehicle.
 * אין שימוש ב-JUnit כדי לשמור על פשטות סטודנטיאלית.
 */
public class ParkingLotUnitTest {

    public static void main(String[] args) {
        testVehicleClone();
        testParkingCost();
        testEnterExitFlow();
    }

    public static void testVehicleClone() {
        Vehicle v = new Vehicle("9999999", "Kia");
        Vehicle copy = v.clone();
        if (!copy.getPlateNumber().equals(v.getPlateNumber())) {
            System.out.println("✅ testVehicleClone עבר");
        } else {
            System.out.println("❌ testVehicleClone נכשל");
        }
    }

    public static void testParkingCost() {
        ParkingLot lot = ParkingLot.getInstance(10);
        Vehicle v = new Vehicle("8888888", "Tesla");
        v.enter();
        try {
            Thread.sleep(2000); // 2 שניות
        } catch (InterruptedException e) {}
        v.exit();
        double cost = lot.calculateCost(v);
        if (cost > 0) {
            System.out.println("✅ testParkingCost עבר, עלות: " + cost);
        } else {
            System.out.println("❌ testParkingCost נכשל");
        }
    }

    public static void testEnterExitFlow() {
        ParkingLot lot = ParkingLot.getInstance(10);
        Vehicle v = new Vehicle("7777777", "Hyundai");
        boolean entered = lot.enterParking(v);
        boolean exited = lot.exitParking(v.getPlateNumber());
        if (entered && exited) {
            System.out.println("✅ testEnterExitFlow עבר");
        } else {
            System.out.println("❌ testEnterExitFlow נכשל");
        }
    }
}