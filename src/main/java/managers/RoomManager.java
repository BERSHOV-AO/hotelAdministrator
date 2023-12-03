package managers;

import enums.RoomStatus;
import models.Room;
import storages.RoomsStorage;

public class RoomManager {
    public RoomsStorage roomsStorage = new RoomsStorage();

    public void addRoom(Room room) {
        roomsStorage.addRoom(room);
    }

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
}
