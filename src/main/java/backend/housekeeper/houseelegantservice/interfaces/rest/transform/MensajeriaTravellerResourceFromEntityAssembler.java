package backend.housekeeper.houseelegantservice.interfaces.rest.transform;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Mensajeria;
import backend.housekeeper.houseelegantservice.domain.model.aggregates.MensajeriaTraveller;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.MensajeriaResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.MensajeriaTravellerResource;

public class MensajeriaTravellerResourceFromEntityAssembler {
    public static MensajeriaTravellerResource toResourceFromEntity(MensajeriaTraveller mensajeriaTraveller) {
        return new MensajeriaTravellerResource(mensajeriaTraveller.getId(), mensajeriaTraveller.getNombre(), mensajeriaTraveller.getDescription(),
                mensajeriaTraveller.getPhotoFace());
    }
}
