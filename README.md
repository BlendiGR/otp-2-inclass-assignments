# OTP2 Week-3 Assignment Fuel Calculator Application

Week 3 exercise of the second-year software engineer project.  

## Prerequisites

- Java 21
- Maven
- Docker & Docker Compose

---

## Database Setup

After pulling the repository to your PC run the following command:
```bash
docker-compose up -d
```

This starts a MariaDB 11 container and automatically runs `schema.sql`, which creates the database, tables, and inserts all localization strings for all 4 languages.

### Database Configuration

Default connection settings (in `DatabaseConnection.java`):

| Setting  | Value                          |
|----------|-------------------------------|
| Host     | `localhost` (or `DB_HOST` env) |
| Port     | `3306`                         |
| Database | `fuel_calculator_localization` |
| User     | `root`                         |
| Password | `1234`                         |

---

## Running Locally

Starts both MariaDB and the app together:

```bash
docker-compose up -d
```

The app image is pulled automatically from `blendigr/blendi_test:latest`.

---

## Database Schema

### `calculation_records`
Stores every calculation the user performs.

| Column      | Type        | Description              |
|-------------|-------------|--------------------------|
| id          | INT (PK)    | Auto-increment           |
| distance    | DOUBLE      | Trip distance in km      |
| consumption | DOUBLE      | Fuel consumption L/100km |
| price       | DOUBLE      | Fuel price per liter     |
| total_fuel  | DOUBLE      | Calculated fuel needed   |
| total_cost  | DOUBLE      | Calculated total cost    |
| language    | VARCHAR(10) | Active language code     |
| created_at  | TIMESTAMP   | Record creation time     |

### `localization_strings`
Stores all UI text for each supported language.

| Column   | Type         | Description                    |
|----------|--------------|--------------------------------|
| id       | INT (PK)     | Auto-increment                 |
| key      | VARCHAR(100) | UI string key                  |
| value    | VARCHAR(255) | Translated string value        |
| language | VARCHAR(10)  | Language code (en/fr/ja/fa)    |

---
