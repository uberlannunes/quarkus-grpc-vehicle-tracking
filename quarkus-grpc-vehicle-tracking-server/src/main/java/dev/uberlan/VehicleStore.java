package dev.uberlan;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class VehicleStore {

    private static final List<Vehicle> VEHICLE_DB = List.of(
            new Vehicle(UUID.randomUUID().toString(), "Black", "Hatch"),
            new Vehicle(UUID.randomUUID().toString(), "White", "Coupé"),
            new Vehicle(UUID.randomUUID().toString(), "Blue", "SUV")
    );

    public List<Vehicle> getAll() {
        return VEHICLE_DB;
    }

    public Optional<Vehicle> getVehicleById(String id) {
        return VEHICLE_DB.stream().filter(v -> v.getId().equals(id)).findFirst();
    }
}
