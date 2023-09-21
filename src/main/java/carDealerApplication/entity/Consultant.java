package carDealerApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "consultant")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Consultant extends AbstractUserEntity {
    private BigDecimal rate;

    @OneToOne
    private Manufacturer manufacturer;
}