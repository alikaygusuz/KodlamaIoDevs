package kodlama.io.devs.dataAccsess.abstracts;

import kodlama.io.devs.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
    boolean existsById(int id);
    boolean existsByName(String name);
    List<Technology> findAllByLanguagesId(int id);
}
