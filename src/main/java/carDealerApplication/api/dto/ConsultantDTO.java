package carDealerApplication.api.dto;

import carDealerApplication.entity.Manufacturer;
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