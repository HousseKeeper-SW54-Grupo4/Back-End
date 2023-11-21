package backend.housekeeper.houseelegantservice.domain.model.command;

public record CreateHouseCommand(String country, String city, String streetAddress,
                                 double price, double rating, String photoUrl, int capacity) {
}
