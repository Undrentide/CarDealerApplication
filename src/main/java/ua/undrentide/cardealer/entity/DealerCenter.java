package ua.undrentide.cardealer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "dealer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DealerCenter extends AbstractEntity {

    @OneToOne
    private Location location;

    @Column(name = "open_hours")
    private LocalTime openHours;

    @Column(name = "close_hours")
    private LocalTime closeHours;

    @OneToMany
    @JoinTable(
            name = "dealer_consultant",
            joinColumns = @JoinColumn(name = "dealer_id"),
            inverseJoinColumns = @JoinColumn(name = "consultant_id")
    )
    private List<Consultant> consultantList;

    @OneToMany
    @JoinTable(
            name = "dealer_car",
            joinColumns = @JoinColumn(name = "dealer_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car> carList;
}