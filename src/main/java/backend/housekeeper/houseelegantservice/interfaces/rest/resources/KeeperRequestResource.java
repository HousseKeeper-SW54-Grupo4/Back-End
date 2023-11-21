package backend.housekeeper.houseelegantservice.interfaces.rest.resources;

public record KeeperRequestResource(Long id, String name, String message, String photoUrl, Float rating) {
}
