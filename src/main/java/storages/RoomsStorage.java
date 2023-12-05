package storages;

import enums.RoomStatus;
import models.Room;
import models.RoomHistory;

import java.util.ArrayList;
import java.util.List;

public class RoomsStorage {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

