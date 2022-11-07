package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.Request.LanguageRequest;
import kodlama.io.devs.business.Response.LanguageResponse;
import kodlama.io.devs.entities.concretes.Languages;


import java.util.List;

public interface LanguageService {
    List<LanguageResponse> getAll()throws Exception;
    void add(LanguageRequest languageRequest)throws Exception;
    void update(LanguageRequest languageRequest, int id)throws Exception;
    void delete(int id)throws Exception;
    LanguageResponse getById(int getElementId)throws Exception;
    Languages getByLanguageId(int getElementId)throws Exception;

}
