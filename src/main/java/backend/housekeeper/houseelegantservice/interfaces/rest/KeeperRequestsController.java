package backend.housekeeper.houseelegantservice.interfaces.rest;

import backend.housekeeper.houseelegantservice.domain.model.query.GetAllKeeperRequestsQuery;
import backend.housekeeper.houseelegantservice.domain.model.query.GetKeeperRequestByIdQuery;
import backend.housekeeper.houseelegantservice.domain.service.KeeperRequestCommandService;
import backend.housekeeper.houseelegantservice.domain.service.KeeperRequestQueryService;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.CreateKeeperRequestResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.resources.KeeperRequestResource;
import backend.housekeeper.houseelegantservice.interfaces.rest.transform.CreateKeeperRequestCommandFromResourceAssembler;
import backend.housekeeper.houseelegantservice.interfaces.rest.transform.KeeperRequestResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/keeperRequest", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "keeperRequest", description = "KeeperRequest Management Endpoints")
public class KeeperRequestsController {
    private final KeeperRequestQueryService keeperRequestQueryService;
    private final KeeperRequestCommandService keeperRequestCommandService;

    public KeeperRequestsController(KeeperRequestQueryService keeperRequestQueryService, KeeperRequestCommandService keeperRequestCommandService) {
        this.keeperRequestQueryService = keeperRequestQueryService;
        this.keeperRequestCommandService = keeperRequestCommandService;
    }

    /**
     * POST /api/v1/keeper-requests
     *
     * <p>Endpoint that creates a keeper request</p>
     * @param resource the resource with the information to create the keeper request
     * @return the created keeper request
     * @see CreateKeeperRequestResource
     * @see KeeperRequestResource
     */
    @PostMapping
    public ResponseEntity<KeeperRequestResource> createKeeperRequest(CreateKeeperRequestResource resource) {

        var createKeeperRequestCommand = CreateKeeperRequestCommandFromResourceAssembler.toCommandFromResource(resource);
        var requestId = keeperRequestCommandService.handle(createKeeperRequestCommand);
        if (requestId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getKeeperRequestByIdQuery = new GetKeeperRequestByIdQuery(requestId);
        var keeperRequest = keeperRequestQueryService.handle(getKeeperRequestByIdQuery);
        if (keeperRequest.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var keeperRequestResource = KeeperRequestResourceFromEntityAssembler.toResourceFromEntity(keeperRequest.get());
        return new ResponseEntity<>(keeperRequestResource, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<KeeperRequestResource>> getAllKeeperRequests() {
        var getAllKeeperRequestQuery = new GetAllKeeperRequestsQuery();
        var keeperRequests = keeperRequestQueryService.handle(getAllKeeperRequestQuery);
        var keeperRequestResourcesces = keeperRequests.stream().map(KeeperRequestResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(keeperRequestResourcesces);
    }
}