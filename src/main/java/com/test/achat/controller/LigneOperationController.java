package com.test.achat.controller;

import java.util.List;
import com.test.achat.entity.LigneOperation;
import com.test.achat.service.impl.LigneOperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ligneOperations")
public class LigneOperationController {
    @Autowired
    private LigneOperationServiceImpl ligneOperationService;

    public LigneOperationServiceImpl getLigneOperationService() {
        return ligneOperationService;
    }

    @RequestMapping(value="createLigneOperation", method= RequestMethod.POST)
    public ResponseEntity<LigneOperation> createLigneOperation(@RequestBody LigneOperation ligneOperation )
    {
        return ResponseEntity.ok(this.getLigneOperationService().create(ligneOperation));
    }
    @RequestMapping(value="createLigneOperationWithClientAndOperation", method= RequestMethod.POST)
    public ResponseEntity<List<LigneOperation>> createLigneOperationWithClientAndOperation(@RequestBody LigneOperation lp)
    {
        //List<LigneOperation> listOp = ligneOperationService.findAll();
        return ResponseEntity.ok(getLigneOperationService().createWithCallingServiceClientandOperation(lp.getId(), lp.getOperation(),lp.getClient(),lp.getStatut(),lp.getAssignation()));
    }
    @RequestMapping(value="/getLigneOperation/{id}", method=RequestMethod.GET)
    public ResponseEntity getLigneOperation(@PathVariable(value = "id") int id) {
        if(getLigneOperationService().findById(id).isPresent())
        {
            return ResponseEntity.ok().body(getLigneOperationService().findById(id).get());
        }
        return new ResponseEntity("ligneOperation "+id+" not founded", null, HttpStatusCode.valueOf(404));
    }
    @RequestMapping(value="getAllLigneOperations", method=RequestMethod.GET)
    public ResponseEntity getAllLigneOperations()
    {
        if (getLigneOperationService().count() != 0)
        {
            return ResponseEntity.ok().body(getLigneOperationService().findAll());
        }
        return new ResponseEntity("No ligneOperation founded", null, HttpStatusCode.valueOf(404));
    }
    @RequestMapping(value="/updateLigneOperation/{id}", method=RequestMethod.PUT)
    public ResponseEntity updateLigneOperation(@PathVariable(value="id") int id, @RequestBody LigneOperation ligneOperation)
    {
        if(ligneOperationService.findById(id).isPresent())
        {
            ligneOperation.setId(id);
            return ResponseEntity.ok().body(getLigneOperationService().update(ligneOperation));
        }
        return new ResponseEntity("ligneOperation "+id+" not founded", null, HttpStatusCode.valueOf(404));
    }
    @DeleteMapping("/deleteLigneOperation/{id}")
    public ResponseEntity<String> deleteLigneOperation(@PathVariable(value = "id") int id)
    {
        if(getLigneOperationService().findById(id).isPresent())
        {
            getLigneOperationService().deleteById(id);
            return ResponseEntity.ok("ligneOperation "+id+" deleted successfully !");
        }
        return new ResponseEntity("ligneOperation "+id+" not founded", null, HttpStatusCode.valueOf(404));
    }

}
