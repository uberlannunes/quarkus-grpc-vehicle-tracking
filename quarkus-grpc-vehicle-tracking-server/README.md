# Quarkus Vehicle Tracking Server

This is a demo project for a Vehicle Tracking System built with Quarkus. The project is a gRPC server that showcases three gRPC services: `GetAllVehicles`, `GetVehicleById`, and `TrackVehicle`.


## Technology Stack

The project utilizes the following technologies and frameworks:

- Java
- Quarkus
- gRPC

## Prerequisites

Before running this project, make sure you have the following prerequisites installed:

- Java JDK 17 or higher
- gRPC client for testing (e.g., Postman)

## Setup

1. Clone the repository:

```shell script
git clone https://github.com/uberlannunes/quarkus-grpc-vehicle-tracking.git
```

2. Navigate to the project directory:
```shell script
cd quarkus-grpc-vehicle-tracking/quarkus-grpc-vehicle-tracking-server
```

3. Run the Application

- Package and Run:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

```shell script
java -jar target/quarkus-grpc-vehicle-tracking-server-1.0.0-SNAPSHOT-runner.jar
```

##### OR

- Run in dev mode:
```shell script
./mvnw compile quarkus:dev
```

## Usage

1. Use a gRPC client (e.g., Postman) to interact with the services:

2. Import the vehicles.proto file into your gRPC client tool to discover the services. The vehicles.proto file can be found in the src/main/proto directory of the project.

3. Once imported, you can find the following gRPC services:

### GetAllVehicles

This service retrieves a list of all vehicles.

> Service Name: GetAllVehicles <br>
> Input: {} <br>
> Response Type: VehicleListResponse


### GetVehicleById

This service retrieves a single vehicle based on the provided vehicle ID.

> Service Name: GetVehicleById <br>
> Input: { "id": "{VEHICLE_ID}" } <br>
> Response Type: VehicleResponse

### TrackVehicle

This service provides a stream of vehicle tracking records for a specific vehicle. The server will send a tracking record every 2 seconds.

> Service Name: TrackVehicle <br>
> Input: { "id": "{VEHICLE_ID}" } <br>
> Response Type: stream VehicleDataTrackerResponse
