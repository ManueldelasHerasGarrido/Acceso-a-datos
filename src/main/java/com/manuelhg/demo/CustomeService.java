package com.manuelhg.demo;

import com.manuelhg.demo.model.Student;

public interface CustomeService<T> {
    T create(T entity);

    T read(T entity);

    T update(T entity);

    boolean delete(T entity);

    boolean validate(Student entity);
}
