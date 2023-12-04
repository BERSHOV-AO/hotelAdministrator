package managers;

import models.Guest;
import models.StayInfo;
import storages.StayInfoStorage;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class StayInfoManager {

    StayInfoStorage stayInfoStorage = new StayInfoStorage();

    public void addStayInfo(int roomNumber, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        stayInfoStorage.addStayInfo(roomNumber, guest, checkInDate, checkOutDate);
    }


    public void deleteStayInfo(int roomNumber) {
        stayInfoStorage.deleteStayInfo(roomNumber);
    }


    public void printStayInfo() {
        Map<Integer, StayInfo> tempInfoStorage =  stayInfoStorage.getInfoStorage();
        for (Map.Entry<Integer, StayInfo> entry : tempInfoStorage.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }



}
