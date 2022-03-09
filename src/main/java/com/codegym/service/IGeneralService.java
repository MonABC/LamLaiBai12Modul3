package com.codegym.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findALl();

    T findById(int id);

    boolean create(T t);

    boolean updateById(int id, T t);

    boolean deleteById(int id);
}
