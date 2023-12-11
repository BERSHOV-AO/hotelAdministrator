package managers;

import enums.RoomHistoryStatus;
import enums.RoomStatus;
import models.*;

import java.time.LocalDate;
import java.util.List;

public class HotelManager {
    RoomManager roomManager = new RoomManager();
    ServiceManager serviceManager = new ServiceManager();
    GuestManager guestManager = new GuestManager();
    RoomHistoryManager roomHistoryManager = new RoomHistoryManager();
    StayInfoManager stayInfoManager = new StayInfoManager();

    //------------------ Guest -----------------------

    public void addGuest(Guest guest) {
        guestManager.addOnGuest(guest);
    }

    public void deleteGuest(Guest guest) {
        guestManager.deleteGuest(guest);
    }

    public void printAllGuest() {
        guestManager.printGuest();
    }
    public void sortGuestsByName() {
        List<Guest> sortedVisitorsByName = guestManager.getSortedGuestsByAlphabet();
        sortedVisitorsByName.stream().forEach(System.out::println);
    }


    //------------------- Room -----------------------

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

    public void printAllRooms() {
        roomManager.printRooms();
    }

    public void printDetailsOfRoom(Room room) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Room details: ");
        stringBuilder.append(roomManager.getRoomDetails(room));
        System.out.println(stringBuilder.toString());
    }

    public void sortRoomsByPrice() {
        List<Room> sortedRoomsByPrice = roomManager.getSortedRoomsByPrice();
        sortedRoomsByPrice.stream().forEach(System.out::println);
    }

    public void sortRoomsByCapacity() {
        List<Room> sortedRoomsByCapacity = roomManager.getSortedRoomsByCapacity();
        sortedRoomsByCapacity.stream().forEach(System.out::println);
    }

    public void sortRoomsByStars() {
        List<Room> sortedRoomsByStars = roomManager.getSortedRoomsByStars();
        sortedRoomsByStars.stream().forEach(System.out::println);
    }

    public void sortEmptyRoomsByPrice() {
        List<Room> sortedEmptyRoomsByStars = roomManager.getFreeRooms(roomManager.getSortedRoomsByPrice());
        sortedEmptyRoomsByStars.stream().forEach(System.out::println);

    }
    public void sortEmptyRoomsByCapacity() {
        List<Room> sortedEmptyRoomsByCapacity = roomManager.getFreeRooms(roomManager.getSortedRoomsByCapacity());
        sortedEmptyRoomsByCapacity.stream().forEach(System.out::println);
    }

    public void sortEmptyRoomsByStars() {
        List<Room> sortedEmptyRoomsByStars = roomManager.getFreeRooms(roomManager.getSortedRoomsByStars());
        sortedEmptyRoomsByStars.stream().forEach(System.out::println);

    }

    public void totalCountEmptyRooms() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("total Count Empty Rooms: ");
        stringBuilder.append(roomManager.totalCountEmptyRooms());
        System.out.println(stringBuilder.toString());
    }



    //---------------------Stay Info -------------------------

    public void showGuestsAlphabeticalOrder() {
        stayInfoManager.getCheckedInGuestsAlphabeticalOrder().forEach(System.out::println);
    }

    public void showFreeRoomsByDate(LocalDate date) {
        stayInfoManager.getFreeRoomsByDate(date).forEach(System.out::println);
    }

    public void showPayAmountForRoom(Room room) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pay Amount For Room : ");
        stringBuilder.append(room.getRoomNumber() + " = ");
        stringBuilder.append(stayInfoManager.getPayAmountForRoom(room) + " руб.");
        System.out.println(stringBuilder.toString());
    }






    //--------------------- Room History ----------------------


    public void printAllRoomHistories() {
        roomHistoryManager.printRoomHistories();
    }

    // -------------------- Service ---------------------
    public void createService(Service service) {
        serviceManager.addService(service);
    }

    public void changeServiceOnPrice(Service service, double price) {
        serviceManager.changeServicePrice(service, price);
    }

    public void printAllService() {
        serviceManager.printService();
    }

    public void showStayInfo() {
        stayInfoManager.printStayInfo();
    }

    //----------------------------------------------------
    public void checkInGuestInRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {

        if (room.getStatus() == RoomStatus.EMPTY) {
            RoomHistory newRoomHistory = new RoomHistory();

            newRoomHistory.setGuest(guest);
            newRoomHistory.setRoom(room);
            newRoomHistory.setCheckInDate(checkInDate);
            newRoomHistory.setCheckOutDate(checkOutDate);
            newRoomHistory.setStatus(RoomHistoryStatus.CHECKIN);

            stayInfoManager.addStayInfo(room, new StayInfo(guest, checkInDate, checkOutDate));


            roomHistoryManager.addHistory(newRoomHistory);
            roomManager.changeRoomStatus(room, RoomStatus.OCCUPIED);
        } else {
            System.out.println("Заселить в комнату " + room.getRoomNumber() + " не представляется возможным. "
                    + "Статус комнаты = " + room.getStatus());
        }
    }

    public void checkOutGuestFromRoom(Guest guest, Room room) {
        if (room.getStatus() == RoomStatus.OCCUPIED) {
            stayInfoManager.deleteStayInfo(room);
            roomManager.changeRoomStatus(room, RoomStatus.EMPTY);
        } else {
            System.out.println("В комнате " + room.getRoomNumber() + " нет посетителей");
        }

    }
}





