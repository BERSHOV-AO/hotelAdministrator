import enums.RoomStatus;
import enums.ServiceType;
import managers.HotelManager;
import models.Guest;
import models.Room;
import models.Service;

import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args) {

        HotelManager hotelManager = new HotelManager();

        Room room1 = new Room(1, 2, 1000, 3, RoomStatus.EMPTY);
        Room room2 = new Room(2, 4, 2000, 2, RoomStatus.EMPTY);
        Room room3 = new Room(3, 3, 1800, 2, RoomStatus.EMPTY);
        Room room4 = new Room(4, 5, 2100, 3, RoomStatus.EMPTY);

        hotelManager.createRoom(room1);
        hotelManager.createRoom(room2);
        hotelManager.createRoom(room3);
        hotelManager.createRoom(room4);


//        hotelManager.printAllRooms();

//        hotelManager.changeRoomStatus(room1, RoomStatus.OCCUPIED);
//        hotelManager.printRooms();
//
//        System.out.println("--------------------------------------------------");
//        hotelManager.changeRoomStatus(room2, RoomStatus.UNDER_REPAIR);
//
//        hotelManager.printRooms();
//
//        hotelManager.changeRoomPrice(room1, 5000);
//        System.out.println(room1);

        System.out.println("---------------------------------------------------------------------------------");
        Service service1 = new Service(ServiceType.BREAKFAST, 150);
        Service service2 = new Service(ServiceType.LUNCH, 100);
        Service service3 = new Service(ServiceType.DINNER, 250);
        Service service4 = new Service(ServiceType.LAUNDRY, 120);

        hotelManager.createService(service1);
        hotelManager.createService(service2);
        hotelManager.createService(service3);
        hotelManager.createService(service4);

        hotelManager.printAllService();
//
//        hotelManager.changeServiceOnPrice(service1, 222);
//
//        System.out.println(service1);
//        System.out.println(service2);


        System.out.println("---------------------------------------------------------------------------------");
        Guest guest1 = new Guest("Alex");
        Guest guest2 = new Guest("Max");
        Guest guest3 = new Guest("Svetlana");
        Guest guest4 = new Guest("Irina");


        hotelManager.addGuest(guest1);
        hotelManager.addGuest(guest2);
        hotelManager.addGuest(guest3);
        hotelManager.addGuest(guest4);

        hotelManager.printAllGuest();

        System.out.println("---------------------------------------------------------------------------------");

        hotelManager.checkInGuestInRoom(guest1, room1, LocalDate.of(2023,12,11), LocalDate.of(2023,12,17));
       // System.out.println(room1.getRoomHistories());



      //  System.out.println(room1.getRoomHistories());


        hotelManager.checkInGuestInRoom(guest2, room2, LocalDate.of(2023,12,22), LocalDate.of(2023,12,28));
        hotelManager.showStayInfo();

        System.out.println("--------------------checkOutGuestFromRoom(guest1, room1)-------------------------");

        hotelManager.checkOutGuestFromRoom(guest1, room1);

        hotelManager.showStayInfo();


        System.out.println("---------------------------------------------");

      //  hotelManager.printAllRoomHistories();


    }
}
