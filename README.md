# Nurse Shifts

## Project Overview
`nurse-shifts` is designed to manage nurses and their shift assignments.

### Key Features
- Manage nurse profiles and shift assignments.
- RESTful API endpoints for CRUD operations.
- Integration with an H2 in-memory database for development and testing.

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8+

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/droksty/nurse-shifts.git
   ```
2. Navigate to the project directory:
   ```bash
   cd nurse-shifts
   ```
3. Build the project:
   ```bash
   ./mvnw clean install
   ```

### Running the Application
To start the application, run:
```bash
./mvnw spring-boot:run
```
The application will be accessible at `http://localhost:8080`.

## Project Structure

### Key Directories
- **`src/main/java/droksty/nurseshifts/controller`**
- **`src/main/java/droksty/nurseshifts/service`**
- **`src/main/java/droksty/nurseshifts/repository`**
- **`src/main/java/droksty/nurseshifts/dto`**
- **`src/main/resources`**

### Data Flow
1. **Controller**: Handles HTTP requests and responses.
2. **Service**: Contains business logic.
3. **Repository**: Interacts with the database.
4. **DTOs**: Facilitate data transfer between layers.

## License
This project is licensed under the terms of the [LICENSE](LICENSE) file.
