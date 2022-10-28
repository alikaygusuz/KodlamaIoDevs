package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.entities.concretes.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/language")
@RestController
public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public List<Languages> getAll() throws Exception {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public Languages getById(@PathVariable()int id)throws Exception{
        return languageService.getById(id);
    }

    @PostMapping
    public Languages add(@RequestBody Languages language) throws Exception {
         return languageService.add(language);

    }

    @PutMapping("/{id}")
    public void update(@RequestBody Languages languages, @PathVariable(name = "id") int id ) throws Exception {
        languageService.update(languages, id);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")int id)throws Exception {
        languageService.delete( id);

    }
}
