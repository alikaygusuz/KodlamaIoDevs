package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.Request.TechnologyRequest;
import kodlama.io.devs.business.Response.TechnologyResponse;
import kodlama.io.devs.business.abstracts.TechnologyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/technologies")
@RestController
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public List<TechnologyResponse> getAll() throws Exception {
        return technologyService.getAll();
    }

    @GetMapping("/{id}")
    public TechnologyResponse getById(@PathVariable() int id) throws Exception{
        return technologyService.getById(id);
    }

    @PostMapping
    public TechnologyResponse add(@RequestBody TechnologyRequest technologyRequest) throws Exception{
        return technologyService.add(technologyRequest);
    }

    @PutMapping("/{id}")
    public TechnologyResponse update(@RequestBody TechnologyRequest technologyRequest, @PathVariable  int id) throws Exception{
        return technologyService.update(technologyRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")int id)throws Exception {
        technologyService.delete(id);
    }

    }
