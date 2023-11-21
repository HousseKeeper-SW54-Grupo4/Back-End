package backend.housekeeper.houseelegantservice.interfaces.rest.transform;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Mensajeria;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.MensajeriaResource;

public class MensajeriaResourceFromEntityAssembler {
    public static MensajeriaResource toResourceFromEntity(Mensajeria mensajeria) {
        return new MensajeriaResource(mensajeria.getId(), mensajeria.getNombre(), mensajeria.getDescription(),
                mensajeria.getPhotoFace());
    }
}