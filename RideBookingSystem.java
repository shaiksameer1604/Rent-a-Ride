import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Driver {
    private String carModel;
    private double rating;
    private double distance;

    public Driver(String carModel, double rating, double distance) {
        this.carModel = carModel;
        this.rating = rating;
        this.distance = distance;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getRating() {
        return rating;
    }

    public double getDistance() {
        return distance;
    }
}

class RideBookingSystem {
    private double rideDistance;
    private String carRequested;
    private List<Driver> drivers;

    public RideBookingSystem(double rideDistance, String carRequested, List<Driver> drivers) {
        this.rideDistance = rideDistance;
        this.carRequested = carRequested;
        this.drivers = drivers;
    }

    public double calculateCharge() {
        return rideDistance * 8;
    }

    public String bookRide() {
        List<Driver> filteredDrivers = filterDrivers();
        sortDriversByDistance(filteredDrivers);

        for (Driver driver : filteredDrivers) {
            if (sendRideRequest(driver)) {
                return "Driver " + driver.getCarModel() + " will get you to the destination.";
            }
        }

        return "No suitable driver found for the requested car model.";
    }

    private List<Driver> filterDrivers() {
        List<Driver> filteredDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.getRating() >= 4 && driver.getCarModel().equalsIgnoreCase(carRequested)) {
                filteredDrivers.add(driver);
            }
        }
        return filteredDrivers;
    }

    private void sortDriversByDistance(List<Driver> drivers) {
        drivers.sort(Comparator.comparingDouble(Driver::getDistance));
    }

    private boolean sendRideRequest(Driver driver) {
        // Simulate sending ride request and driver acceptance
        return true;
    }
}