package ua.undrentide.cardealer.api.dto;

import lombok.Builder;

import java.util.Map;

@Builder
public class CarDTO {
    public Map<String, String> engine;
    public String color;
    public String brand;
    public String country;
    public Integer price;
}