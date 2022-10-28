package kodlama.io.devs.dataAccsess.concretes;

import kodlama.io.devs.dataAccsess.abstracts.LanguagesRepository;
import kodlama.io.devs.entities.concretes.Languages;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryLanguageRepository implements LanguagesRepository {
    List<Languages> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<Languages>();
        languages.add(new Languages(1,"Java"));
        languages.add(new Languages(2,"C#"));
        languages.add(new Languages(3,"Python"));
        languages.add(new Languages(4,"Javascript"));
        languages.add(new Languages(5,"Php"));

    }

    @Override
    public List<Languages> getAll() {
        return languages;
    }

    @Override
    public Languages add(Languages language) {
         languages.add(language);
         return getById(language.getId());

    }

    @Override
    public Languages update(Languages language, int id) {
        List<Languages> languagesList = getAll();
        for (Languages l: languagesList) {
            if (l.getId() == id ){
                l.setName(language.getName());
            }
        }
        return null;
    }

    @Override
    public Languages delete(int id) {
        List<Languages> languagesList = getAll();
        languagesList.removeIf(l -> l.getId() == id);
        return null;
    }

    @Override
    public Languages getById(int getElementId) {
        for (Languages lang:languages) {
            if (lang.getId() == getElementId){
                return lang;
            }

        }
        return null;
    }


}
