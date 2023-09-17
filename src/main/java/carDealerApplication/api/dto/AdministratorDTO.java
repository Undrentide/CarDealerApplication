package carDealerApplication.api.dto;

import carDealerApplication.entity.DealerCenter;

import java.util.List;

public class AdministratorDTO {
    public long id;
    public String firstName;
    public String lastName;
    public Long phone;
    public String login;
    public String password;
    public List<DealerCenter> dealerCenterList;
}