package managers;

import models.Guest;
import models.Room;
import storages.GuestStorage;

import java.util.List;

public class GuestManager {

    GuestStorage guestStorage = new GuestStorage();

    public void addOnGuest(Guest guest) {
        guestStorage.addGuest(guest);
    }

    public void deleteGuest(Guest guest) {
        guestStorage.deleteGuest(guest);
    }

    public void printAllGuest() {
        List<Guest> tempGuest = guestStorage.getGuests();
        for (Guest guest : tempGuest) {
            System.out.println(guest);
        }
    }

}
