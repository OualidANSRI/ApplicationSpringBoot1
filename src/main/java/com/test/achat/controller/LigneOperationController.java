package com.test.achat.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import com.test.achat.entity.LigneOperation;
import com.test.achat.service.impl.LigneOperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ligneOperations")
public class LigneOperationController {


    @Autowired
    public LigneOperationServiceImpl ligneOperationService;
    @RequestMapping(value="createLigneOperation", method= RequestMethod.POST)
    public ResponseEntity<?> createLigneOperation(@RequestBody LigneOperation ligneOperation )
    {

        return ResponseEntity.ok(ligneOperationService.create(ligneOperation));
    }

    @RequestMapping(value="/getAllLigneOperations", method=RequestMethod.GET)
    public List<LigneOperation> getAllLigneOperations() {

        return ligneOperationService.findAll();
    }

    @RequestMapping(value="/getLigneOperation/{id}", method=RequestMethod.GET)
    public LigneOperation getLigneOperation(@PathVariable(value = "id") int id) {
        return this.ligneOperationService.getById(id);
    }

    /**
     * @throws AccessDeniedException
     */

    @RequestMapping(value="/updateLigneOperation/{id}", method=RequestMethod.PUT)
    public ResponseEntity<LigneOperation> updateLigneOperation(@PathVariable(value="id") int id, @RequestBody LigneOperation ligneOperation) {

        if (ligneOperationService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            ligneOperation = ligneOperationService.update(ligneOperation);
            return ResponseEntity.ok().body(ligneOperation);
        }
    }


    /**
     * Delete a given address in the database
     *
     * @throws
     * @throws AccessDeniedException
     **/
    @DeleteMapping("/deleteLigneOperation/{id}")
    public List<LigneOperation> deleteLigneOperation(@PathVariable(value = "id") int idLigneOperation)
            throws AccessDeniedException {
        ligneOperationService.deleteById(idLigneOperation);
        return ligneOperationService.findAll();

    }
}
