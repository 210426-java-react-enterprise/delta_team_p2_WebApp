package com.revature.WebApp.repositories;

import com.revature.WebApp.entities.PrototypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Empty repository is needed to autowire repo object that can invoke CRUD on entity.
 * Just extend CrudRepository and include your entity type and the type of the Id field
 * as type parameters.
 */
@Repository
public interface PrototypeRepository extends CrudRepository<PrototypeEntity, Integer> {

}
