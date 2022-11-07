package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.Request.LanguageRequest;
import kodlama.io.devs.business.Response.LanguageResponse;
import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccsess.abstracts.LanguagesRepository;
import kodlama.io.devs.entities.concretes.Languages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LanguageManager implements LanguageService {
    Logger logger = LoggerFactory.getLogger(LanguageManager.class);

    private LanguagesRepository languagesRepository;


    @Autowired
    public LanguageManager(LanguagesRepository languagesRepository) {

        this.languagesRepository = languagesRepository;

    }

    @Override
    public List<LanguageResponse> getAll() {
        logger.trace("Bütün programlama dilleri listelendi!");
        List<LanguageResponse> languageResponses = new ArrayList<>();
        for (Languages lang: languagesRepository.findAll()) {
            languageResponses.add(createLanguageResponse(lang));
        }
        return languageResponses;
    }

    @Override
    public void add(LanguageRequest languageRequest) throws Exception {
        if (isNameExist(languageRequest)) throw new Exception("Programlama dili ismi tekrar edemez!!!");
        if (languageRequest.getName().isBlank()) {
            throw new Exception("İsim parametresi boş bıralılamaz");
        }
        logger.trace(String.format("Yeni bir programlama dili %s tarafından 'name' = {%s}, objesi eklendi!", "YARLIG", languageRequest.getName()));
        Languages languages = new Languages();
        languages.setName(languageRequest.getName());
        languagesRepository.save(languages);

    }

    @Override
    public void update(LanguageRequest languageRequest, int id) throws Exception {
        if (isNameExist(languageRequest)) throw new Exception("Programlama dili ismi tekrar edemez!!!");
        if (!isIdExist(id)) throw new Exception("Id bulunamadı!!!");
        logger.trace(String.format("Id parametresi 'id' = {%d} olan obje %s tarafından 'name' = {%s}, olarak güncellendi!", id, "YARLIG", languageRequest.getName()));
        Languages languages = new Languages();
        languages.setId(id);
        languages.setName(languageRequest.getName());
        languagesRepository.save(languages);

    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) throw new Exception("Id bulunamadı!!!");
        logger.trace(String.format("Id parametresi 'id' = {%d} olan obje %s tarafından silindi!", id, "YARLIG"));
        languagesRepository.deleteById(id);
    }

    @Override
    public LanguageResponse getById(int getElementId) throws Exception {
        Optional<Languages> language = languagesRepository.findById(getElementId);
        if(language.isPresent()){
            logger.trace(String.format("Id parametresi 'id' = {%d} olan obje %s tarafından getirildi", getElementId, "YARLIG"));
            return createLanguageResponse(language.get());
        }
        logger.trace(String.format("Id parametresi 'id' = {%d} olan obje bulunamadı!", getElementId, "YARLIG"));
        throw new Exception("Id bulunamadı!!!");


    }

    @Override
    public Languages getByLanguageId(int getElementId) throws Exception {
        Optional<Languages> language = languagesRepository.findById(getElementId);
        if(language.isPresent()){
            logger.trace(String.format("Id parametresi 'id' = {%d} olan obje %s tarafından getirildi", getElementId, "YARLIG"));
            return language.get();
        }
        logger.trace(String.format("Id parametresi 'id' = {%d} olan obje bulunamadı!", getElementId, "YARLIG"));
        throw new Exception("Id bulunamadı!!!");
    }

    public boolean isNameExist(LanguageRequest languageRequest) {
       return languagesRepository.existsByNameIgnoreCase(languageRequest.getName());
    }

    public boolean isIdExist(int id) {
        return languagesRepository.existsById(id);
        }




    private LanguageResponse createLanguageResponse(Languages languages){
        LanguageResponse languageResponse = new LanguageResponse();
        languageResponse.setId(languages.getId());
        languageResponse.setName(languages.getName());
        return languageResponse;
    }
}


