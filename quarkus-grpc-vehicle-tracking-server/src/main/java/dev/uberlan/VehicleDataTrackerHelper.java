package dev.uberlan;

import java.util.random.RandomGenerator;

public class VehicleDataTrackerHelper {

    private static final RandomGenerator generator = RandomGenerator.getDefault();

    /**
     * Random Data
     *
     * @param vehicleId
     * @return
     */
    public static VehicleDataTrackerResponse getData(String vehicleId) {
        int speed = generator.nextInt(60, 100);
        double latitude = generator.nextDouble(-23.71, -23.52);
        double longitude = generator.nextDouble(-46.76, -46.67);

        return VehicleDataTrackerResponse
                .newBuilder()
                .setVehicleId(vehicleId)
                .setSpeed(speed)
                .setLatitude(String.valueOf(latitude))
                .setLongitude(String.valueOf(longitude))
                .build();
    }
}
