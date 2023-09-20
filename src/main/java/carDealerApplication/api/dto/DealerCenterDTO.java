package carDealerApplication.api.dto;

import lombok.Builder;

@Builder
public class DealerCenterDTO {
    public LocationDTO locationDTO;
    public String hours;
}