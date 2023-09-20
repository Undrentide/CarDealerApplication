package carDealerApplication.api.dto;

import carDealerApplication.entity.DealerCenter;
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