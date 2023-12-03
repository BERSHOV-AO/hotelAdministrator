package managers;

import enums.RoomStatus;
import models.Room;
import storages.RoomsStorage;

public class RoomManager {
    public RoomsStorage roomsStorage = new RoomsStorage();

    public void addRoom(Room room) {
        roomsStorage.addRoom(room);
    }

    public void changeRoomStatus(Room room, RoomStatus roomStatus) {
        roomsStorage.changeRoomStatus(room, roomStatus);
    }

}
