package kodlama.io.devs.dataAccsess.abstracts;

import kodlama.io.devs.entities.concretes.Languages;

import java.util.List;

public interface LanguagesRepository {
    List<Languages> getAll();
    void add(Languages language);
    void update(Languages language, int id);
    void delete(int id);
    Languages getById(int getElementId);
}
