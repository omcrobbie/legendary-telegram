package com.example.demo.generic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.utils.DataNotFoundException;

@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
public abstract class EntityController<T extends BaseEntity, R extends IEntityRepository<T>, M extends IEntityMapper<T>> {

    protected CRUDService<T, R, M> crudService;

    public EntityController(CRUDService<T, R, M> crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public List<T> getAll() {
        return crudService.getAll();
    }

    @GetMapping(path = "/{id}")
    public T getOne(@PathVariable String id) throws DataNotFoundException {
        return crudService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody T entity) {
        crudService.addOne(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody T entity)
            throws DataNotFoundException {
        crudService.updateOne(id, entity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) throws DataNotFoundException {
        crudService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
