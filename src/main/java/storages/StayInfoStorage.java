package storages;

import models.Room;
import models.StayInfo;

import java.util.LinkedHashMap;
import java.util.Map;

public class StayInfoStorage {

    private Map<Room, StayInfo> infoStorage = new LinkedHashMap<>();

    public void addStayInfo(Room room, StayInfo stayInfo) {
        infoStorage.put(room, stayInfo);
    }

    public void deleteStayInfo(Room room) {
        infoStorage.remove(room);
    }

    public Map<Room, StayInfo> getInfoStorage() {
        return infoStorage;
    }
}
