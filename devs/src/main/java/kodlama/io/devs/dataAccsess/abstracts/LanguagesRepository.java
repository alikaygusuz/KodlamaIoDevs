package kodlama.io.devs.dataAccsess.abstracts;


import kodlama.io.devs.entities.concretes.Languages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguagesRepository extends JpaRepository<Languages, Integer> {
    boolean existsById(int id);
    boolean existsByNameIgnoreCase(String name);

}
