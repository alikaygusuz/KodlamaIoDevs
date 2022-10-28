package kodlama.io.devs.dataAccsess.abstracts;

import kodlama.io.devs.entities.concretes.Languages;

import java.util.List;

public interface LanguagesRepository {
    List<Languages> getAll();
    Languages add(Languages language);
    Languages update(Languages language, int id);
    Languages delete(int id);
    Languages getById(int getElementId);
}
