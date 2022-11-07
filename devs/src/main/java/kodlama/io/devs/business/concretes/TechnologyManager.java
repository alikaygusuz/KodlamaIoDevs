package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.Request.TechnologyRequest;
import kodlama.io.devs.business.Response.TechnologyResponse;
import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.dataAccsess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Technology;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j


public class TechnologyManager implements TechnologyService {


    Logger logger = LoggerFactory.getLogger(LanguageManager.class);

    TechnologyRepository technologyRepository;
    LanguageService languageService;

    public TechnologyManager( TechnologyRepository technologyRepository, LanguageService languageService) {
        this.technologyRepository = technologyRepository;
        this.languageService = languageService;
    }

    @Override
    public List<TechnologyResponse> getAll() {
        logger.trace("Bütün Framework'ler dilleri listelendi!");
        List<TechnologyResponse> technologyResponses = new ArrayList<>();
        System.out.println("Test");
        for (Technology tech:technologyRepository.findAll()) {
            technologyResponses.add(createTechnologyResponse(tech));
        }

        return technologyResponses;
    }

    @Override
    public TechnologyResponse getById(int id) throws Exception {
        Optional<Technology> technology = technologyRepository.findById(id);
        if(technology.isPresent()){
            logger.trace(String.format("Id parametresi 'id' = {%d} olan framework %s tarafından getirildi", id, "YARLIG"));
            return createTechnologyResponse(technology.get());
        }
        logger.trace(String.format("%s kullanıcısı Id parametresi 'id' = {%d} olan framework'ü getirmek istedi fakat ilgili id'ye ait hathangi bir framwork mevcut değil!","YARLIG", id));
        throw new Exception("Id bulunamadı!!!");
    }

    @Override
    public TechnologyResponse add(TechnologyRequest technologyRequest) throws Exception {
        if (isNameExist(technologyRequest)) throw new Exception("Programlama dili ismi tekrar edemez!!!");
        if (technologyRequest.getName().isBlank()) {
            logger.trace("İsim parametresi boş bırakılamaz.");
            throw new Exception("İsim parametresi boş bıralılamaz");
        }

        logger.trace(String.format("'name' = {%s} isimli framework  %s tarafından 'languageId' = {%s} olan programlama diline eklendi.",technologyRequest.getName(), "YARLIG",technologyRequest.getLanguageId()   ));
        Technology technology = new Technology();
        technology.setLanguages(this.languageService.getByLanguageId(technologyRequest.getLanguageId()));
        technology.setName(technologyRequest.getName());
        Technology indbTechnology = technologyRepository.save(technology);
        return createTechnologyResponse(indbTechnology);
    }

    @Override
    public TechnologyResponse update(TechnologyRequest technologyRequest, int id) throws Exception {
        if (isNameExist(technologyRequest)) throw new Exception("Framework dili ismi tekrar edemez!!!");
        if (!isIdExist(id)) throw new Exception("Id bulunamadı!!!");
        logger.trace(String.format("Id parametresi 'id' = {%d} olan ve 'languageId' = {%d} olan framework %s tarafından güncellendi!", id,technologyRequest.getLanguageId(), "YARLIG"));
        Technology technology = technologyRepository.findById(id).get();
        technology.setName(technologyRequest.getName());
        technology.setLanguages(this.languageService.getByLanguageId(technologyRequest.getLanguageId()));
        Technology indbTechnology = technologyRepository.save(technology);
        return createTechnologyResponse(indbTechnology);
    }




    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) throw new Exception("Id bulunamadı!!!");
        logger.trace(String.format("Id parametresi 'id' = {%d} olan obje %s tarafından silindi!", id, "YARLIG"));
        technologyRepository.deleteById(id);

    }

    @Override
    public List<TechnologyResponse> getByLanguageId(int id) {
        List<Technology> technologies = technologyRepository.findAllByLanguagesId(id);
        List<TechnologyResponse> technologyResponses = new ArrayList<>();
        for (Technology tech: technologies) {
            technologyResponses.add(createTechnologyResponse(tech));

        }
        return technologyResponses;
    }

    private TechnologyResponse createTechnologyResponse(Technology technology){
        TechnologyResponse technologyResponse = new TechnologyResponse();
        technologyResponse.setId(technology.getId());
        technologyResponse.setName(technology.getName());
        technologyResponse.setLanguagesId(technology.getLanguages().getId());
        return technologyResponse;
    }



    public boolean isNameExist(TechnologyRequest technologyRequest) {
        return technologyRepository.existsByName(technologyRequest.getName());
    }

    public boolean isIdExist(int id) {

        return technologyRepository.existsById(id);
    }
}
