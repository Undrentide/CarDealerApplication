package ua.undrentide.cardealer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "administrator")
@Data
@SuperBuilder
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