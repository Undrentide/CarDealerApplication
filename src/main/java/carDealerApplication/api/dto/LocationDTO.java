package carDealerApplication.api.dto;

import lombok.Builder;

@Builder
public class LocationDTO {
    public String country;
    public String city;
    public String street;
}