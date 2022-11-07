package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.Request.TechnologyRequest;
import kodlama.io.devs.business.Response.TechnologyResponse;

import java.util.List;

public interface TechnologyService {
    List<TechnologyResponse> getAll();
    TechnologyResponse getById(int id) throws Exception;
    TechnologyResponse add (TechnologyRequest technologyRequest) throws Exception;
    TechnologyResponse update(TechnologyRequest technologyRequest, int id) throws Exception;


    void delete(int id) throws Exception;

    List<TechnologyResponse> getByLanguageId(int id);
}
