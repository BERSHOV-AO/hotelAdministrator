package storages;

import models.Guest;
import models.Room;
import models.StayInfo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StayInfoStorage {

    private Map<Integer, StayInfo> infoStorage = new HashMap<>();

    public void addStayInfo(int roomNumber, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        infoStorage.put(roomNumber, new StayInfo(guest, checkInDate, checkOutDate));
    }

    public void deleteStayInfo(int roomNumber) {
        infoStorage.remove(roomNumber);
    }

    public Map<Integer, StayInfo> getInfoStorage() {
        return infoStorage;
    }



}
