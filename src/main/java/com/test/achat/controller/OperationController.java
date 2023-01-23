package com.test.achat.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import com.test.achat.entity.Operation;
import com.test.achat.service.impl.OperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/operations")
public class OperationController {


    @Autowired
    public OperationServiceImpl operationService;
    @RequestMapping(value="createOperation", method= RequestMethod.POST)
    public ResponseEntity<?> createOperation(@RequestBody Operation operation )
    {

        return ResponseEntity.ok(operationService.create(operation));
    }

    /***
     * return the list of all address
     *
     **/
    @RequestMapping(value="/getAllOperations", method=RequestMethod.GET)
    public List<Operation> getAllOperations() {

        return operationService.findAll();
    }

    /**
     * return Address by id
     *
     **/
    @RequestMapping(value="/getOperation/{id}", method=RequestMethod.GET)
    public ResponseEntity<Operation> getOperation(@PathVariable(value = "id") int id) {
        if (operationService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(operationService.getById(id));
        }    }

    /**
     * modify a given Address in the database
     *

     * @throws AccessDeniedException
     */

    @RequestMapping(value="/updateOperation/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Operation> updateOperation(@PathVariable(value="id") int id, @RequestBody Operation operation) {

        if (operationService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            operation = operationService.update(operation);
            return ResponseEntity.ok().body(operation);
        }
    }


    /**
     * Delete a given address in the database
     *
     * @throws
     * @throws AccessDeniedException
     **/
    @RequestMapping(value="/deleteOperation/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Operation> deleteOperation(@PathVariable(value = "id") int id)
            throws AccessDeniedException {
        if (operationService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            operationService.deleteById(id);
            return ResponseEntity.ok().build();

        }
    }
}
