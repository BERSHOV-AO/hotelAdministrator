package storages;

import models.Room;
import models.StayInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StayInfoStorage {

    private Map<Room, StayInfo> infoStorage = new ConcurrentHashMap<>();

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
