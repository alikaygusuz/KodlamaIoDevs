package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.concretes.Languages;

import java.util.List;

public interface LanguageService {
    List<Languages> getAll()throws Exception;
    void add(Languages language)throws Exception;
    void update(Languages language, int id)throws Exception;
    void delete(int id)throws Exception;
    Languages getById(int getElementId)throws Exception;
}
