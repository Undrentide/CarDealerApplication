package carDealerApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "offer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecialOffer extends AbstractEntity {
    @OneToMany
    @JoinTable(
            name = "offer_location",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> countries;
    private Integer amount;
    private String description;
}