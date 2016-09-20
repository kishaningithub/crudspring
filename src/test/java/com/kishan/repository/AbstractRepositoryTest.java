package com.kishan.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractRepositoryTest {

    @PersistenceContext
    protected EntityManager entityManager;

    public<T> T save(T t)
    {
        entityManager.persist(t);
        return t;
    }

    public JPAQuery from(EntityPath<?>... paths) {
        return new JPAQuery(entityManager).from(paths);
    }
}
