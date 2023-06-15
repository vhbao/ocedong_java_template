package com.ocedong.javatemplate.repository.template;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@org.springframework.stereotype.Repository
@Transactional
public class Repository implements IRepository {
    @PersistenceContext
    EntityManager entityManager;
}
