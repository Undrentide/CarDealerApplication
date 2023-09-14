package carDealerApplication.entity;

import jakarta.persistence.Column;
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
public class Consultant extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private long phone;
    private String login;
    private String password;
    private double rate;
    @OneToOne
    private Manufacturer manufacturer;
}