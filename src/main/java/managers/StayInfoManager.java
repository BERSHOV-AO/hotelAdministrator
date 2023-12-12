package managers;

import models.Guest;
import models.Room;
import models.StayInfo;
import storages.StayInfoStorage;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StayInfoManager {

    StayInfoStorage stayInfoStorage = new StayInfoStorage();

    public void addStayInfo(Room room, StayInfo stayInfo) {
        stayInfoStorage.addStayInfo(room, stayInfo);
    }

    public void deleteStayInfo(Room room) {
        stayInfoStorage.deleteStayInfo(room);
    }

    public void printStayInfo() {
        stayInfoStorage.getInfoStorage().forEach((room, stayInfo) -> {
            System.out.println("Room: " + room.getRoomNumber());
            System.out.println("Guest: " + stayInfo.getGuest().getLastName());
            System.out.println("Check-in date: " + stayInfo.getCheckInDate());
            System.out.println("Check-out date: " + stayInfo.getCheckOutDate());
            System.out.println("--------------------------------------");
        });
    }

    public List<Room> getFreeRoomsByDate(LocalDate date) {
        return stayInfoStorage.getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getValue().getCheckInDate().isAfter(date)
                        || entry.getValue().getCheckOutDate().isBefore(date))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public double getPayAmountForRoom(Room room) {
        return stayInfoStorage.getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getKey().equals(room))
                .findFirst()
                .map(entry -> {
                    LocalDate checkInDate = entry.getValue().getCheckInDate();
                    LocalDate checkOutDate = entry.getValue().getCheckOutDate();
                    int duration = (int) checkInDate.until(checkOutDate).getDays();
                    double pricePerNight = room.getPrice();
                    return duration * pricePerNight;
                })
                .orElse(0.0);
    }

    public LinkedHashMap<Room, StayInfo> getLastThreeGuests() {
        LinkedHashMap<Room, StayInfo> infoStorage = (LinkedHashMap<Room, StayInfo>) stayInfoStorage.getInfoStorage();
        return infoStorage.entrySet().stream()
                .skip(Math.max(0, infoStorage.size() - 3))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}





