package carDealerApplication.entity;

import carDealerApplication.util.JpaConverterJson;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "car")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car extends AbstractEntity {
    @Convert(converter = JpaConverterJson.class)
    @ColumnTransformer(write = "?::jsonb")
    private Map<String, String> engine;
    private String color;
    private String brand;
    private String country;
    private int price;
    private boolean isAvailable;
}