package managers;

import models.Service;
import storages.ServicesStorage;

public class ServiceManager {

    ServicesStorage servicesStorage = new ServicesStorage();

    public void addService(Service service) {
        servicesStorage.addService(service);
    }

    public void changeServicePrice(Service service, double price) {
        servicesStorage.getServices().stream()
                .filter(r -> r.getServiceType() == service.getServiceType())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }


}
