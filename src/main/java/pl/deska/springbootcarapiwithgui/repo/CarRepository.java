package pl.deska.springbootcarapiwithgui.repo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.deska.springbootcarapiwithgui.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByProductionYearIsBetween(int from, int to);



}
