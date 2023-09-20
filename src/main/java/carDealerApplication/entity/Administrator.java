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
public class Administrator extends AbstractUserEntity {

    @OneToMany
    @JoinTable(
            name = "administrator_dealer",
            joinColumns = @JoinColumn(name = "administrator_id"),
            inverseJoinColumns = @JoinColumn(name = "dealer_id")
    )
    private List<DealerCenter> dealerCenterList;
}