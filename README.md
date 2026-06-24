# 🚗 Carpooling Project

A simple and practical backend REST API application built using **Spring Boot**. This project helps manage user registration, ride creation, and a seat-booking system with basic security and database controls.

---

## 🛠️ Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **Database:** MySQL & Spring Data JPA
* **Security:** Spring Security & JWT
* **API Testing:** Swagger UI

---

## 📝 Project Features (What I Have Done)

* **User Management:** Basic registration and login APIs.
* **Stateless Security:** Integrated **Spring Security and JWT** so that requests can be securely authenticated.
* **Ride Search Optimization:** Used **Pagination and Sorting** so that searching for rides doesn't load all data at once.
* **Overbooking Protection:** Implemented **Optimistic Locking (`@Version`)** to make sure two people cannot book the same seat at the exact same time.
* **Interactive Testing:** Integrated **Swagger UI** to easily test all the URLs directly from the browser without needing Postman.

---

## 🚀 Key Endpoints To Test

* `POST /api/auth/register` - New user sign up.
* `POST /api/auth/login` - User login (Returns JWT token).
* `POST /api/rides` - Create a new ride.
* `GET /api/rides` - Search available rides (with Pagination).
* `POST /api/bookings` - Book a seat in a ride.
