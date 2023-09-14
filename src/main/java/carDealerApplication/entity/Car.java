package carDealerApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "car")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car extends AbstractEntity {
    private Map<String, String> engine;
    private String color;
    private String brand;
    private String country;
    private int price;
    private boolean isAvailable;
}