package carDealerApplication.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "administrator")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Administrator extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private long phone;
    private String login;
    private String password;
    @OneToMany
    @JoinTable(
            name = "administrator_dealer",
            joinColumns = @JoinColumn(name = "administrator_id"),
            inverseJoinColumns = @JoinColumn(name = "dealer_id")
    )
    private List<DealerCenter> dealerCenterList;
}