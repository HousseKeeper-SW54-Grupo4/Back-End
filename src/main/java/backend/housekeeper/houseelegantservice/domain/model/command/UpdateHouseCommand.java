package backend.housekeeper.houseelegantservice.domain.model.command;

public record UpdateHouseCommand(String country, String city, String streetAddress,
                                 Float price, Float rating, String photoUrl, Integer capacity) {
}