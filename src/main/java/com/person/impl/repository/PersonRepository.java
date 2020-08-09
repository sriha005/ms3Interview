package com.person.impl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.person.impl.entity.*;


@Repository
public interface PersonRepository extends CrudRepository<PersonEntity,Long> {

}
