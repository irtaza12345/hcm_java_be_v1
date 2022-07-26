package com.conurets.hcm.persistence.dao;

import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.persistence.entity.BaseEntity;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

public interface BaseDAO<E extends BaseEntity> {
    void save(E entity) throws HCMException;

    void saveOrUpdate(E entity) throws HCMException;

    void update(E entity) throws HCMException;

    void delete(E entity) throws HCMException;

    E findById(long id) throws HCMException;

    List<E> findAll() throws HCMException;

    List<E> findAll(List<Integer> status) throws HCMException;

    E findByKeyValue(String key, Object value) throws HCMException;

    List<E> findAllByKeyValue(String key, Object value) throws HCMException;
}