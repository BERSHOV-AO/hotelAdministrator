package managers;

import enums.RoomStatus;
import models.Room;

public class HotelManager {
    RoomManager roomManager = new RoomManager();

    public void createRoom(Room room) {
        roomManager.addRoom(room);
    }

    public void changeRoomStatus(Room room, RoomStatus roomStatus) {
        roomManager.changeRoomStatus(room, roomStatus);
    }

    // Изменить цену номера
    public void changeRoomPrice(Room room, double price) {
        roomManager.changeRoomPrice(room, price);
    }

}