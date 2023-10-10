package ua.undrentide.cardealer.api.dto;

import ua.undrentide.cardealer.entity.DealerCenter;
import lombok.Builder;

import java.util.List;

@Builder
public class AdministratorDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public Long phone;
    public String login;
    public String password;
    public List<DealerCenter> dealerCenterList;
}