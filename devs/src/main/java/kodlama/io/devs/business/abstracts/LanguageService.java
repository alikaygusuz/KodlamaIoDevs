package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.concretes.Languages;

import java.util.List;

public interface LanguageService {
    List<Languages> getAll()throws Exception;
    Languages add(Languages language)throws Exception;
    Languages update(Languages language, int id)throws Exception;
    Languages delete(int id)throws Exception;
    Languages getById(int getElementId)throws Exception;
}
