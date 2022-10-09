package com.example.testtask.repository;

import com.example.testtask.models.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
// Репозиторий для сотрудников
@Transactional
@Repository
public interface PersonRepository extends JpaRepository<Persons, Long> {

    Persons getById(long id);

    @Query("from Persons p")
    List<Persons> findByAll();

    @Query("from Persons p where p.id= :id")
    List<Persons> findByPersonId(@Param("id") long id);

    @Query("select p.city.country.id from Persons p where p.id= :id")
    int findByPersonAllCity(@Param("id") long id);

    @Query("from Persons p where p.lastName like %:lastname% order by p.firstName" )
    List<Persons> findByLastName(@Param("lastname") String lastname);

}


