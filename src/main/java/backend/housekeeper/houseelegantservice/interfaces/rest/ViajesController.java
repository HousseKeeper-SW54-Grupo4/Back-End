package backend.housekeeper.houseelegantservice.interfaces.rest;

import backend.housekeeper.houseelegantservice.domain.model.queries.GetViajeAllQuery;
import backend.housekeeper.houseelegantservice.domain.model.queries.GetViajeByIdQuery;
import backend.housekeeper.houseelegantservice.domain.service.ViajeCommandService;
import backend.housekeeper.houseelegantservice.domain.service.ViajeQueryService;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.CreateViajeResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.ViajeResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.transform.CreateViajeCommandFromResourceAssembler;
import backend.housekeeper.houseelegantservice.interfaces.rest.transform.ViajeResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/viajes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Viajes", description = "Viaje Management Endpoints")
public class ViajesController {
    private final ViajeQueryService viajeQueryService;
    private final ViajeCommandService viajeCommandService;

    public ViajesController(ViajeQueryService viajeQueryService, ViajeCommandService viajeCommandService) {
        this.viajeQueryService = viajeQueryService;
        this.viajeCommandService = viajeCommandService;
    }

    /**
     * POST /api/v1/viajes
     *
     * <p>Endpoint that creates a viaje</p>
     * @param resource the resource with the information to create the viaje
     * @return the created viaje
     * @see CreateViajeResource
     * @see ViajeResource
     */
    @PostMapping
    public ResponseEntity<ViajeResource> createViaje(CreateViajeResource resource) {

        var createViajeCommand = CreateViajeCommandFromResourceAssembler.toCommandFromResource(resource);
        var viajeId = viajeCommandService.handle(createViajeCommand);
        if (viajeId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getViajeByIdQuery = new GetViajeByIdQuery(viajeId);
        var viaje = viajeQueryService.handle(getViajeByIdQuery);
        if (viaje.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var viajeResource = ViajeResourceFromEntityAssembler.toResourceFromEntity(viaje.get());
        return new ResponseEntity<>(viajeResource, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ViajeResource>> getAllViajes() {
        var getViajesAllQuery = new GetViajeAllQuery();
        var viajes = viajeQueryService.handle(getViajesAllQuery);
        if (viajes.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var viajeResources = viajes.stream().map(ViajeResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(viajeResources);

    }
}