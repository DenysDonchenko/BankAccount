package com.bank.api.service;

import java.util.Collection;
import java.util.Optional;

public interface BaseService<ENTITY, ID> {

    Collection<ENTITY> findAll();

    Optional<ENTITY> findById(ID id);

    ENTITY create(ENTITY entity);

    ENTITY update(ENTITY entity, ID id);

    boolean existsById(ID id);



}
