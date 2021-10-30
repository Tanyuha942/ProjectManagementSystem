package com.goit.dao.dao_interfaces;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Identity> {
    List<T> getAll();
    Optional<T> get(Long id);
    Optional<T> create(T entity);
    void update(T entity);
    void delete(T entity);
}