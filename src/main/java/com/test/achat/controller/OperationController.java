package com.test.achat.controller;

import com.test.achat.entity.Operation;
import com.test.achat.service.impl.OperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/operations")
public class OperationController {
    @Autowired
    private OperationServiceImpl operationService;

    public OperationServiceImpl getOperationService() {
        return operationService;
    }

    @RequestMapping(value="createOperation", method= RequestMethod.POST)
    public ResponseEntity<Operation> createOperation(@RequestBody Operation operation )
    {
        return ResponseEntity.ok(getOperationService().create(operation));
    }
    @RequestMapping(value="getAllOperations", method=RequestMethod.GET)
    public ResponseEntity getAllOperations()
    {
        if(getOperationService().count() != 0)
        {
            return ResponseEntity.ok().body(getOperationService().findAll());
        }
        return new ResponseEntity("No Operation founded", null, HttpStatusCode.valueOf(404));
    }
    @RequestMapping(value="/getOperation/{id}", method=RequestMethod.GET)
    public ResponseEntity getOperation(@PathVariable(value = "id") int id)
    {    if(getOperationService().findById(id).isPresent())
        {
            return ResponseEntity.ok().body(getOperationService().findById(id).get());
        }
        return new ResponseEntity("No Operation founded", null, HttpStatusCode.valueOf(404));
    }
    @RequestMapping(value="/updateOperation/{id}", method=RequestMethod.PUT)
    public ResponseEntity updateOperation(@PathVariable(value="id") int id, @RequestBody Operation operation)
    {
        if (getOperationService().findById(id).isPresent())
        {
            operation.setId(id);
            return ResponseEntity.ok().body(getOperationService().update(operation));
        }
        return new ResponseEntity("Operation "+id+" not founded", null, HttpStatusCode.valueOf(404));
    }
    @RequestMapping(value="/deleteOperation/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteOperation(@PathVariable(value = "id") int id)
    {
        if (getOperationService().findById(id).isPresent())
        {
            getOperationService().deleteById(id);
            return ResponseEntity.ok("Operation "+id+" deleted");
        }
        return new ResponseEntity("Operation "+id+" not founded", null, HttpStatusCode.valueOf(404));
    }
    @RequestMapping(value="/deleteAllOperations", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteAllOperations()
    {
        if (getOperationService().count() != 0)
        {
            getOperationService().deleteAll();
            return ResponseEntity.ok("All operations deleted successfully !");
        }
        return new ResponseEntity("No operation founded", null, HttpStatusCode.valueOf(404));
    }

}
