package com.example.mediapp.Disease;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepo extends CrudRepository<Disease,Long> {
    Disease findDiseaseByName(String name);

    @Query(value="select name from disease",nativeQuery = true)
    List<String> getAllDiseaseNames();
    //Disease findByDiseaseId(long disease_id);
}
