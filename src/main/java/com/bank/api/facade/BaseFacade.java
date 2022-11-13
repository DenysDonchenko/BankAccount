package com.bank.api.facade;

import java.util.Collection;

public interface BaseFacade <ENTITY, DTO, ID>{

    Collection<ENTITY> findAll();

    ENTITY findById(ID id);

    ENTITY create(DTO entity);

    ENTITY update(DTO entity, ID id);

    boolean existsById(ID id);
}
