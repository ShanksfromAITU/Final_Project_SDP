# Enterprise Logistics & Fleet Management

A Java console application that simulates a delivery workflow: creating an order, selecting a vehicle and route, adding extra services, and tracking delivery progress.

The project demonstrates six design patterns working together in one application.

## Features

- Create delivery orders with sender, receiver, origin, destination, and cargo weight.
- Create motorcycles, vans, and trucks with different load capacities.
- Select an available vehicle that can carry the cargo.
- Compare routes by travel time, distance, or cost.
- Add insurance and fragile cargo handling to the delivery price.
- Manage delivery status transitions.
- Notify customers and record status changes in an in-memory log.
- Release the assigned vehicle when delivery is completed.

## Design Patterns and Responsibilities

| Team member | Pattern | Purpose |
|-------------|---------|---------|
| Dias        | Builder | Construct delivery orders step by step |
| Dias        | Decorator | Add optional services and their costs |
| Amir        | Factory Method | Create different vehicle types through concrete factories |
| Amir        | Strategy | Select the fastest, shortest, or cheapest route |
| Ayaulym     | State | Control delivery actions according to the current status |
| Ayaulym     | Observer | Notify subscribers when the delivery status changes |

## Delivery Workflow

1. Create an order using `DeliveryOrderBuilder`.
2. Create the fleet using vehicle factories.
3. Select the first available vehicle with sufficient capacity.
4. Compare available routes using interchangeable strategies.
5. Calculate the delivery price with optional services.
6. Register customer notifications and delivery logging.
7. Assign the vehicle, dispatch the delivery, and complete it.

The delivery follows these states:

`Created → Assigned → InTransit → Delivered`

Invalid actions, such as completing a delivery before dispatch, are rejected.

## Project Structure

| Package | Contents |
|---------|----------|
| `logistics.builder` | Delivery order builder |
| `logistics.decorator` | Basic delivery and additional services |
| `logistics.factory` | Vehicle factories |
| `logistics.model` | Order, route, and vehicle models |
| `logistics.observer` | Customer notifications and delivery history |
| `logistics.state` | Delivery context and status implementations |
| `logistics.strategy` | Route selection strategies and route planner |

The application entry point is `src/logistics/Main.java`.

## Requirements

- JDK 17 or newer
- IntelliJ IDEA or a terminal
- No external libraries

## Running in IntelliJ IDEA

1. Clone the repository and open the project folder.
2. Select an installed JDK 17 or newer as the project SDK.
3. If needed, configure a Java module and mark `src` as Sources Root.
4. Open `src/logistics/Main.java`.
5. Run the `main()` method.

IDE configuration files are not included in the repository.

## Running from the Terminal

Run the following commands from the project folder.

### Windows PowerShell

```powershell
$files = (Get-ChildItem src -Recurse -Filter *.java).FullName
javac -encoding UTF-8 -d out $files
if ($LASTEXITCODE -eq 0) { java -cp out logistics.Main }
```

### macOS / Linux

```bash
find src -name "*.java" > sources.txt
javac -encoding UTF-8 -d out @sources.txt && java -cp out logistics.Main
```

## Example Scenario

The demonstration creates a 500 kg delivery from Astana to Almaty.

| Item | Result |
|------|--------|
| Selected vehicle | Van |
| Selected route | Economy road |
| Base delivery price | 30,000 KZT |
| Insurance | 2,000 KZT |
| Fragile cargo handling | 1,500 KZT |
| Total price | 33,500 KZT |
| Final status | Delivered |
| Vehicle availability after delivery | Available |

Route distances, travel times, and prices are illustrative values.

## Validation

The application checks that:

- Required order fields are not empty.
- Cargo weight is positive and finite.
- A vehicle is available before assignment.
- Cargo weight does not exceed vehicle capacity.
- Route values are valid.
- Route selection receives a non-empty list.
- Delivery actions follow the allowed state transitions.

## Current Scope

The application runs a predefined console demonstration. It does not currently provide an interactive menu, real GPS tracking, or persistent storage. Delivery history is kept in memory during execution.

## Future Improvements

- Interactive console menu for creating and managing orders.
- Saving and loading orders and fleet data.
- Routes associated with specific origins and destinations.
- Storage of the selected route and final price with each delivery.
- Unique order identifiers for tracking multiple deliveries.