package backend.housekeeper.houseelegantservice.interfaces.rest.resources;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.Viaje;

public record ViajeResource(Long id, String title, String description, String photoUrl, float rating)  {

}
