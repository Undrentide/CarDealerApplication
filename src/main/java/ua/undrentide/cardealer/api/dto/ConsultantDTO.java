package ua.undrentide.cardealer.api.dto;

import ua.undrentide.cardealer.entity.Manufacturer;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class ConsultantDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public Long phone;
    public String login;
    public String password;
    public BigDecimal rate;
    public Manufacturer manufacturer;
}