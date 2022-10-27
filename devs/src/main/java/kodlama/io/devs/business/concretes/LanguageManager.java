package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccsess.abstracts.LanguagesRepository;
import kodlama.io.devs.entities.concretes.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class LanguageManager implements LanguageService  {


    private LanguagesRepository languagesRepository;

    @Autowired
    public LanguageManager(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
    }

    @Override
    public List<Languages> getAll() {

        return languagesRepository.getAll();
    }

    @Override
    public void add(Languages language)throws Exception {
        if(isNameExist(language)) throw new Exception("Programlama dili ismi tekrar edemez!!!");
        if(isIdExist(language.getId())) throw new Exception("Id tekrar edemez!!!");
        languagesRepository.add(language);

    }

    @Override
    public void update(Languages language, int id)throws Exception {
        if(isNameExist(language)) throw new Exception("Programlama dili ismi tekrar edemez!!!");
        if(!isIdExist(id)) throw new Exception("Id bulunamadı!!!");
        languagesRepository.update(language, id);

    }

    @Override
    public void delete(int id)throws Exception {
        if(!isIdExist(id)) throw new Exception("Id bulunamadı!!!");
        languagesRepository.delete(id);
    }

    @Override
    public Languages getById(int getElementId)throws Exception {
        if(!isIdExist(getElementId)) throw new Exception("Id bulunamadı!!!");
        return languagesRepository.getById(getElementId);
    }

    public boolean isNameExist (Languages languages){
        for (Languages l:languagesRepository.getAll()) {
            if (l.getName().equals(languages.getName())){
                return true;
            };
        }
        return false;
    }

    public boolean isIdExist (int id){
        for (Languages I:languagesRepository.getAll()) {
            if (I.getId() ==id){
                return true;
            };
        }
        return false;
    }
}
