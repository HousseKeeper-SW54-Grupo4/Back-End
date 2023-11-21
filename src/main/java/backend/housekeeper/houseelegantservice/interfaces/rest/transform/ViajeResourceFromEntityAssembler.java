package backend.housekeeper.houseelegantservice.interfaces.rest.transform;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Viaje;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.ViajeResource;

public class ViajeResourceFromEntityAssembler {
    public static ViajeResource toResourceFromEntity(Viaje viaje) {
        return new ViajeResource(viaje.getId(), viaje.getTitle(), viaje.getDescription(),
                viaje.getPhotoUrl(), viaje.getRating());
    }
}