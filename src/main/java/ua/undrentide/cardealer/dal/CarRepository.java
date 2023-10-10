package ua.undrentide.cardealer.dal;

import ua.undrentide.cardealer.entity.Car;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByIsAvailable(Boolean isAvailable, PageRequest pageRequest);

    List<Car> findAll();
}