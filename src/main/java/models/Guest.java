package models;

import java.util.Date;

public class Guest {

    private int id = 0;
    private String lastName;

    private RoomHistory history;

    public Guest(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RoomHistory getHistory() {
        return history;
    }

    public void setHistory(RoomHistory history) {
        this.history = history;
    }

    //    private String name;
//    private int roomNumber;
//    private Date checkInDate;
//    private Date checkOutDate;
//
//    public Guest(String name, int roomNumber, Date checkInDate, Date checkOutDate) {
//        this.name = name;
//        this.roomNumber = roomNumber;
//        this.checkInDate = checkInDate;
//        this.checkOutDate = checkOutDate;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getRoomNumber() {
//        return roomNumber;
//    }
//
//    public Date getCheckInDate() {
//        return checkInDate;
//    }
//
//    public Date getCheckOutDate() {
//        return checkOutDate;
//    }
//
//    @Override
//    public String toString() {
//        return "Guest{" +
//                "name='" + name + '\'' +
//                ", roomNumber=" + roomNumber +
//                ", checkInDate=" + checkInDate +
//                ", checkOutDate=" + checkOutDate +
//                '}';
//    }

    @Override
    public String toString() {
        return "Guest{" +
                "lastName='" + lastName + '\'' +
                ", history=" + history +
                '}';
    }
}
