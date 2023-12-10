package managers;

import models.Guest;
import models.Room;
import models.StayInfo;
import storages.StayInfoStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StayInfoManager {

    StayInfoStorage stayInfoStorage = new StayInfoStorage();

//    public void addStayInfo(int roomNumber, StayInfo stayInfo) {
//        stayInfoStorage.addStayInfo(roomNumber, stayInfo);
//    }
//
//    public void deleteStayInfo(int roomNumber) {
//        stayInfoStorage.deleteStayInfo(roomNumber);
//    }
//
//    public void printStayInfo() {
//        Map<Integer, StayInfo> tempInfoStorage = stayInfoStorage.getInfoStorage();
//        for (Map.Entry<Integer, StayInfo> entry : tempInfoStorage.entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
//    }

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
//        return rooms.stream()
//                .filter(room -> stays.stream()
//                        .noneMatch(stay -> stay.getCheckInDate().isBefore(date) && stay.getCheckOutDate().isAfter(date)))
//                .collect(Collectors.toList());


//            return stayInfoStorage.getInfoStorage().stream()
//                    .filter(room -> stays.entrySet().stream()
//                            .noneMatch(entry -> entry.getValue().getCheckInDate().isBefore(date) && entry.getValue().getCheckOutDate().isAfter(date)))
//                    .collect(Collectors.toList());
        return stayInfoStorage.getInfoStorage().entrySet().stream()
                .filter(entry -> entry.getValue().getCheckInDate().isAfter(date) || entry.getValue().getCheckOutDate().isBefore(date))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        }

    }

//        List<HotelRoom> freeRoom = new ArrayList<>();
//        for (HotelRoom room : rooms) {
//            if (room.getStatus() == RoomStatus.FREE && isRoomFreeOnDate(room.getRoomNumber(), date)) {
//                freeRoom.add(room);
//            }
//
//        }
//        return freeRoom;
  //  }


//}



