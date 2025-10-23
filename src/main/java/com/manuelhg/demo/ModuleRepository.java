package com.manuelhg.demo;

import com.manuelhg.demo.repository.CrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ModuleRepository implements CrudRepository<Module> {

    /**
     * @param entity
     * @return
     */
    @Override
    public Module create(Module entity) {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Module read(Module entity) {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public Module update(Module entity) {
        return null;
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public boolean delete(Module entity) {
        return false;
    }
}