package ua.undrentide.cardealer.api.dto;

import lombok.Builder;

import java.time.LocalTime;

@Builder
public class DealerCenterDTO {
    public LocationDTO locationDTO;
    public LocalTime openHours;
    public LocalTime closeHours;
}