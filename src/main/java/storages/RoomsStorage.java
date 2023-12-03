package storages;

import enums.RoomStatus;
import models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomsStorage {
    private List<Room> rooms = new ArrayList<>();
    private int counter = 0;

    // Добавить номер
    public void addRoom(Room room) {
        rooms.add(room);
        counter++;
    }


    // Изменить статус номера
    public void changeRoomStatus(Room room, RoomStatus status) {
        rooms.stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setStatus(status);
                    rooms.set(rooms.indexOf(r), r);
                });

//        if(rooms.contains(room)) {
//
//        }
//
//        Room room = findRoomByNumber(roomNumber);
//        if (room != null) {
//            room.setStatus(status);
//            System.out.println("У комнаты " + roomNumber + " статус изменен на " + status);
//        } else {
//            System.out.println("Комната " + roomNumber + " не существует");
//        }
    }

    // Изменить цену номера
    public void changeRoomPrice(int roomNumber, double price) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null) {
            room.setPrice(price);
            System.out.println("У комнаты " + roomNumber + " цена изменена на " + price);
        } else {
            System.out.println("Комната " + roomNumber + " не существует");
        }
    }

    // Поиск комнаты
    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }


}
