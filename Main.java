import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Sedan", 4, 500));
        drivers.add(new Driver("Hatchback", 4.3, 1000));
        drivers.add(new Driver("5-Seater", 4.8, 200));
        drivers.add(new Driver("Sedan", 4.1, 700));
        drivers.add(new Driver("Hatchback", 4.7, 430));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the customer ride distance: ");
        double rideDistance = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the car requested: ");
        String carRequested = scanner.nextLine();

        System.out.print("Enter the destination: ");
        String destination = scanner.nextLine();

        System.out.println("Available Cars:");
        for (Driver driver : drivers) {
            System.out.println(driver.getCarModel());
        }
        System.out.println();

        RideBookingSystem ride = new RideBookingSystem(rideDistance, carRequested, drivers);
        String output = ride.bookRide();
        double charge = ride.calculateCharge();

        System.out.println(output);
        System.out.println("Your charge will be Rs " + charge);

        scanner.close(); // Close the scanner
    }
}