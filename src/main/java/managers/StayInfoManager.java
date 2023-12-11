package managers;

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
            // System.out.println("Total amount: " + stayInfo.getTotalAmount());
            System.out.println("--------------------------------------");
        });
    }

    public List<String> getCheckedInGuestsAlphabeticalOrder() {
        List<StayInfo> values = new ArrayList<>(stayInfoStorage.getInfoStorage().values());
        return values.stream()
                .map(value -> value.getGuest().getLastName())
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Room> getFreeRoomsByDate(LocalDate date) {
        return stayInfoStorage.getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getValue().getCheckInDate().isAfter(date) || entry.getValue().getCheckOutDate().isBefore(date))
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
}





