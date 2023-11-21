package backend.housekeeper.houseelegantservice.interfaces.rest.resources;

public record CreateKeeperRequestResource(String name, String message, String photoUrl, Float rating) {
}
