package managers;

import enums.RoomStatus;
import models.Room;
import models.RoomHistory;
import storages.RoomsStorage;

import java.util.List;

public class RoomManager {
    public RoomsStorage roomsStorage = new RoomsStorage();

    public void addRoom(Room room) {
        roomsStorage.addRoom(room);
    }

//    public void printRooms() {
//        List<Room> tempRooms = roomsStorage.getRooms();
//        for (Room room : tempRooms) {
//            System.out.println(room);
//        }
//    }


    // Изменить статус номера
    public void changeRoomStatus(Room room, RoomStatus status) {
        roomsStorage.getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setStatus(status);
                });
    }

    // Изменить цену номера
    public void changeRoomPrice(Room room, double price) {
        roomsStorage.getRooms().stream()
                .filter(r -> r.getRoomNumber() == room.getRoomNumber())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }

    public void updateRoomHistory(Room room, RoomHistory history) {
        roomsStorage.updateRoomHistory(room, history);
    }
}
