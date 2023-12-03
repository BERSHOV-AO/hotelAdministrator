package managers;

import enums.RoomStatus;
import models.Room;
import models.Service;

public class HotelManager {
    RoomManager roomManager = new RoomManager();
    ServiceManager serviceManager = new ServiceManager();

    //------------------ Guest -----------------------


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

    // -------------------- Service ---------------------
    public void createService(Service service) {
        serviceManager.addService(service);
    }

    public void changeServiceOnPrice(Service service, double price) {
        serviceManager.changeServicePrice(service, price);
    }

}
