package carDealerApplication.api.dto;

import carDealerApplication.entity.Manufacturer;

public class ConsultantDTO {
    public long id;
    public String firstName;
    public String lastName;
    public Long phone;
    public String login;
    public String password;
    public Double rate;
    public Manufacturer manufacturer;
}