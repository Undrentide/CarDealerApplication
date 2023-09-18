package carDealerApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "consultant")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consultant extends AbstractUserEntity {
    private Double rate;
    @OneToOne
    private Manufacturer manufacturer;
}