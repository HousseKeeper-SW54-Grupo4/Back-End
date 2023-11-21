package backend.housekeeper.houseelegantservice.interfaces.rest;

import backend.housekeeper.houseelegantservice.domain.model.aggregates.MensajeriaTraveller;
import backend.housekeeper.houseelegantservice.domain.service.MensajeriaTravellerCommandService;
import backend.housekeeper.houseelegantservice.domain.service.MensajeriaTravellerQueryService;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.CreateMensajeriaResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.CreateMensajeriaTravellerResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.MensajeriaTravellerResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.transform.CreateMensajeriaTravellerCommandFromResourceAssembler;
import backend.housekeeper.houseelegantservice.interfaces.rest.transform.MensajeriaTravellerResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/MensajesTraveller", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "MensajesTraveller", description = "Mensajeria traveller Management Endpoints")
public class MensajeriaTravellerController {
    private final MensajeriaTravellerQueryService mensajeriaTravellerQueryService;
    private final MensajeriaTravellerCommandService mensajeriaTravellerCommandService;

    public MensajeriaTravellerController(MensajeriaTravellerQueryService mensajeriaTravellerQueryService, MensajeriaTravellerCommandService mensajeriaTravellerCommandService) {
        this.mensajeriaTravellerQueryService = mensajeriaTravellerQueryService;
        this.mensajeriaTravellerCommandService = mensajeriaTravellerCommandService;
    }

    /**
     * POST /api/v1/MensajesTraveller
     *
     * <p>Endpoint that creates a mensaje</p>
     * @param resource the resource with the information to create the mensaje
     * @return the created mensaje
     * @see CreateMensajeriaResource
     * @see MensajeriaTravellerResource
     */
    @PostMapping
    public ResponseEntity<MensajeriaTravellerResource> createMensajeria(CreateMensajeriaTravellerResource resource) {

        var createMensajeriaCommand = CreateMensajeriaTravellerCommandFromResourceAssembler.toCommandFromResource(resource);
        var mensajeriaId = mensajeriaTravellerCommandService.createMensajeriaTraveller(createMensajeriaCommand);

        if (mensajeriaId == null) {
            return ResponseEntity.badRequest().build();
        }

        var mensajeria = mensajeriaTravellerQueryService.getMensajeriaTravellerById(mensajeriaId.getId());
        if (mensajeria == null) {
            return ResponseEntity.badRequest().build();
        }

        var mensajeriaResource = MensajeriaTravellerResourceFromEntityAssembler.toResourceFromEntity(mensajeria);
        return new ResponseEntity<>(mensajeriaResource, HttpStatus.CREATED);
    }
    @GetMapping
    public List<MensajeriaTraveller> getAllMensajes() {
        return mensajeriaTravellerQueryService.getAllMensajes();
    }
}