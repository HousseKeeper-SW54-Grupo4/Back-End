package backend.housekeeper.houseelegantservice.interfaces.rest;

import backend.housekeeper.houseelegantservice.domain.model.query.GetAllMensajesQuery;
import backend.housekeeper.houseelegantservice.domain.model.query.GetMensajeriaByIdQuery;
import backend.housekeeper.houseelegantservice.domain.service.MensajeriaCommandService;
import backend.housekeeper.houseelegantservice.domain.service.MensajeriaQueryService;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.CreateMensajeriaResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.MensajeriaResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.transform.CreateMensajeriaCommandFromResourceAssembler;
import backend.housekeeper.houseelegantservice.interfaces.rest.transform.MensajeriaResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/Mensajes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mensajes", description = "Mensajeria Management Endpoints")
public class MensajeriaController {
    private final MensajeriaQueryService mensajeriaQueryService;
    private final MensajeriaCommandService mensajeriaCommandService;

    public MensajeriaController(MensajeriaQueryService mensajeriaQueryService, MensajeriaCommandService mensajeriaCommandService) {
        this.mensajeriaQueryService = mensajeriaQueryService;
        this.mensajeriaCommandService = mensajeriaCommandService;
    }

    /**
     * POST /api/v1/mensajes
     *
     * <p>Endpoint that creates a mensaje</p>
     * @param resource the resource with the information to create the mensaje
     * @return the created mensaje
     * @see CreateMensajeriaResource
     * @see MensajeriaResource
     */
    @PostMapping
    public ResponseEntity<MensajeriaResource> createMensajeria(CreateMensajeriaResource resource) {

        var createMensajeriaCommand = CreateMensajeriaCommandFromResourceAssembler.toCommandFromResource(resource);
        var mensajeriaId = mensajeriaCommandService.handle(createMensajeriaCommand);

        if (mensajeriaId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getMensajeriaByIdQuery = new GetMensajeriaByIdQuery(mensajeriaId);
        var mensajeria = mensajeriaQueryService.handle(getMensajeriaByIdQuery);
        if (mensajeria.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var mensajeriaResource = MensajeriaResourceFromEntityAssembler.toResourceFromEntity(mensajeria.get());
        return new ResponseEntity<>(mensajeriaResource, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<MensajeriaResource>> getAllMensajes() {
        var getAllMensajes = new GetAllMensajesQuery();
        var mensajes = mensajeriaQueryService.handle(getAllMensajes);
        var mensajeResources = mensajes.stream().map(MensajeriaResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(mensajeResources);
    }
}