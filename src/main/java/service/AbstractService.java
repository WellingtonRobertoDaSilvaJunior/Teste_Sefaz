/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author Jr
 * @param <T>
 */
public abstract class AbstractService<T> {

    private Class<T> entityClass;

    public AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract T create(T entity);

    public abstract T edit(T entity);

    public abstract T remove(T entity);

    public abstract T find(Object id);

    public abstract List<T> findAll();

    public abstract List<T> findRange(int[] range);
    
}
