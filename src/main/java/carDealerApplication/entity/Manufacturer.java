package carDealerApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "manufacturer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer extends AbstractEntity {
    private String name;
    private String country;
    private Short originationYear;
}