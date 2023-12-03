package models;

import enums.RoomStatus;

import java.util.Objects;

public class Room {
    private int roomNumber;
    private int stars;
    private double price;
    private int capacity;
    private RoomStatus status;

    public Room(int roomNumber, int stars, double price, int capacity) {
        this.roomNumber = roomNumber;
        this.stars = stars;
        this.price = price;
        this.capacity = capacity;
        this.status = RoomStatus.FREE;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getStars() {
        return stars;
    }

    public double getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "roomNumber=" + roomNumber +
                ", stars=" + stars +
                ", price=" + price +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber && stars == room.stars && Double.compare(room.price, price) == 0 && capacity == room.capacity && status == room.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, stars, price, capacity, status);
    }
}