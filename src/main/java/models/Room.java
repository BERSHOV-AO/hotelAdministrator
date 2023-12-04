package models;

import enums.RoomStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {
    private int roomNumber;
    private int stars;
    private double price;
    private int capacity;
    private RoomStatus status;

    private RoomHistory roomHistories;

    public Room(int roomNumber, int stars, double price, int capacity, RoomStatus status) {
        this.roomNumber = roomNumber;
        this.stars = stars;
        this.price = price;
        this.capacity = capacity;
        this.status = status;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }


    public RoomHistory getRoomHistories() {
        return roomHistories;
    }

    public void setRoomHistories(RoomHistory roomHistories) {
        this.roomHistories = roomHistories;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", stars=" + stars +
                ", price=" + price +
                ", capacity=" + capacity +
                ", status=" + status +
          //      ", roomHistories=" + roomHistories +
                '}';
    }
}