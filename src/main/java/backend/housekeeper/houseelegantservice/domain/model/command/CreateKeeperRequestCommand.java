package backend.housekeeper.houseelegantservice.domain.model.command;

public record CreateKeeperRequestCommand(String name, String message, String photoUrl, Float rating) {
}