package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.Request.LanguageRequest;
import kodlama.io.devs.business.Response.LanguageResponse;
import kodlama.io.devs.business.Response.TechnologyResponse;
import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.abstracts.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/language")
@RestController
public class LanguageController {
    private LanguageService languageService;
    private TechnologyService technologyService;

    @Autowired
    public LanguageController(LanguageService languageService, TechnologyService technologyService) {
        this.languageService = languageService;
        this.technologyService= technologyService;
    }




    @GetMapping
    public List<LanguageResponse> getAll() throws Exception {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public LanguageResponse getById(@PathVariable()int id)throws Exception{
        return languageService.getById(id);
    }
    @GetMapping("/{id}/technologies")
    public List<TechnologyResponse> getTechnologiesByLanguageId(@PathVariable()int id)throws Exception{

        return technologyService.getByLanguageId(id);
    }

    @PostMapping
    public void add(@RequestBody LanguageRequest languageRequest) throws Exception {
         languageService.add(languageRequest);

    }

    @PutMapping("/{id}")
    public void update(@RequestBody LanguageRequest languageRequest, @PathVariable(name = "id") int id ) throws Exception {
        languageService.update(languageRequest, id);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")int id)throws Exception {
        languageService.delete( id);

    }
}
