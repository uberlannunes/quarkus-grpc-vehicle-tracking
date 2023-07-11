package dev.uberlan;

import com.google.protobuf.Empty;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@GrpcService
public class VehicleGrpcService implements VehicleGrpc {

    private final VehicleStore vehicleStore;

    public VehicleGrpcService(VehicleStore vehicleStore) {
        this.vehicleStore = vehicleStore;
    }

    @Override
    public Uni<VehicleListResponse> getAllVehicles(Empty request) {
        List<VehicleResponse> vehicles = vehicleStore.getAll()
                .stream()
                .map(v -> VehicleResponse.newBuilder().setId(v.getId()).setColor(v.getColor()).setModel(v.getModel()).build())
                .toList();

        return Uni.createFrom().item(vehicles)
                .map(v -> VehicleListResponse.newBuilder().addAllVehicles(v).build());
    }

    @Override
    public Uni<VehicleResponse> getVehicleById(VehicleRequest request) {
        Optional<Vehicle> vehicleById = vehicleStore.getVehicleById(request.getId());
        return vehicleById
                .map(v -> Uni.createFrom().item(v)
                        .map(vh -> VehicleResponse.newBuilder().setId(vh.getId()).setColor(vh.getColor()).setModel(vh.getModel()).build()))
                .orElse(Uni.createFrom().nullItem());
    }

    @Override
    public Multi<VehicleDataTrackerResponse> trackVehicle(VehicleRequest request) {
        Optional<Vehicle> vehicleById = vehicleStore.getVehicleById(request.getId());
        return vehicleById
                .map(v -> Multi.createFrom()
                        .ticks().every(Duration.ofSeconds(2))
                        .map(l -> VehicleDataTrackerHelper.getData(request.getId())))
                .orElse(Multi.createFrom().empty());
    }
}
