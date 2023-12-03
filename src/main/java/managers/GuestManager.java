package managers;

import models.Guest;
import models.Room;
import storages.GuestStorage;

public class GuestManager {

    GuestStorage guestStorage = new GuestStorage();

    public void addOnGuest(Guest guest) {
        guestStorage.addGuest(guest);
    }


}
