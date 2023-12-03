import enums.RoomStatus;
import managers.HotelManager;
import managers.RoomManager;
import models.Room;

public class MainTest {
    public static void main(String[] args) {

        HotelManager hotelManager = new HotelManager();

        Room room1 = new Room(1, 2, 1000, 3);
        Room room2 = new Room(2, 4, 2000, 2);

        hotelManager.createRoom(room1);
        hotelManager.createRoom(room2);

        hotelManager.changeRoomStatus(room1, RoomStatus.OCCUPIED);

        System.out.println(room1);
        System.out.println(room2);

        hotelManager.changeRoomStatus(room2, RoomStatus.UNDER_REPAIR);

        System.out.println(room1);
        System.out.println(room2);

        hotelManager.changeRoomPrice(room1, 5000);
        System.out.println(room1);





    }
}
