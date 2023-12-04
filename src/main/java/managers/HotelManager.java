package managers;

import enums.RoomStatus;
import models.Guest;
import models.Room;
import models.Service;

public class HotelManager {
    RoomManager roomManager = new RoomManager();
    ServiceManager serviceManager = new ServiceManager();
    GuestManager guestManager = new GuestManager();

    //------------------ Guest -----------------------

    public void addGuest(Guest guest) {
        guestManager.addOnGuest(guest);
    }

    public void deleteGuest(Guest guest) {
        guestManager.deleteGuest(guest);
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

    public void printRooms() {
        roomManager.printAllRooms();
    }

    // -------------------- Service ---------------------
    public void createService(Service service) {
        serviceManager.addService(service);
    }

    public void changeServiceOnPrice(Service service, double price) {
        serviceManager.changeServicePrice(service, price);
    }

}
