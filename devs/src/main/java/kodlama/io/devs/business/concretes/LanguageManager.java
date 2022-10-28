package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccsess.abstracts.LanguagesRepository;
import kodlama.io.devs.entities.concretes.Languages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;


import java.util.List;


@Service
public class LanguageManager implements LanguageService  {
    Logger logger = LoggerFactory.getLogger(LanguageManager.class);

    private LanguagesRepository languagesRepository;


    @Autowired
    public LanguageManager(LanguagesRepository languagesRepository) {

        this.languagesRepository = languagesRepository;

    }

    @Override
    public List<Languages> getAll() {
        logger.trace("Bütün programlama dilleri listelendi!");
        return languagesRepository.getAll();
    }

    @Override
    public Languages add(Languages language)throws Exception {
        if(isNameExist(language)) throw new Exception("Programlama dili ismi tekrar edemez!!!");
        if(isIdExist(language.getId())) throw new Exception("Id tekrar edemez!!!");
        if (language.getName().isEmpty()){
            throw  new Exception("İsim parametresi boş bıralılamaz");
        }
        String s = language.getName();
        if (!Pattern.matches("[a-zA-Z]+",s)) {
            throw  new Exception("İsim parametresi bir karakter içermelidir!");
        }
        logger.trace("Yeni bir programlama dili YARLIG tarafından eklendi!");
        return languagesRepository.add(language);

    }

    @Override
    public Languages update(Languages language, int id)throws Exception {
        if(isNameExist(language)) throw new Exception("Programlama dili ismi tekrar edemez!!!");
        if(!isIdExist(id)) throw new Exception("Id bulunamadı!!!");
        logger.trace("Var olan bir programlama dili YARLIG tarafından güncellendi!");
        return languagesRepository.update(language, id);

    }

    @Override
    public Languages delete(int id)throws Exception {
        if(!isIdExist(id)) throw new Exception("Id bulunamadı!!!");
        logger.trace("Var olan bir programlama dili YARLIG tarafından silindi!");
        return languagesRepository.delete(id);
    }

    @Override
    public Languages getById(int getElementId)throws Exception {
        if(!isIdExist(getElementId)) throw new Exception("Id bulunamadı!!!");
        logger.trace("Programlama dili id'ye bağlı olarak getirildi!");
        return languagesRepository.getById(getElementId);
    }

    public boolean isNameExist (Languages languages){
        for (Languages l:languagesRepository.getAll()) {
            if (l.getName().equalsIgnoreCase(languages.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean isIdExist (int id){
        for (Languages I:languagesRepository.getAll()) {
            if (I.getId() ==id){
                return true;
            }
        }
        return false;
    }

}
