package com.test.achat.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import com.test.achat.entity.Client;
import com.test.achat.service.impl.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")
public class ClientController {

    /**
     * Create GpAddress in the database
     *
     **/
    @Autowired
    public ClientServiceImpl clientService;
    @RequestMapping(value="createClient", method= RequestMethod.POST)
    public ResponseEntity<?> createClient(@RequestBody Client client )
             {

        return ResponseEntity.ok(clientService.create(client));
    }

    /***
     * return the list of all address
     *
     **/
    @RequestMapping(value="/getAllClients", method=RequestMethod.GET)
    public List<Client> getAllClients() {
        return clientService.findAll();
    }

    /**
     * return Address by id
     *
     **/
    @RequestMapping(value="/getClient/{id}", method=RequestMethod.GET)
    public ResponseEntity<Client> getClient(@PathVariable(value = "id") int id) {

        if (clientService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(clientService.getById(id));
        }
    }

    /**
     * modify a given Address in the database
     *

     * @throws AccessDeniedException
     */

    @RequestMapping(value="/updateClient/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable(value="id") int id,@Valid @RequestBody Client client) {

        if (clientService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            client = clientService.update(client);
            return ResponseEntity.ok().body(client);
        }
    }


    /**
     * Delete a given address in the database
     *
     * @throws
     * @throws AccessDeniedException
     **/
    @Query(value = "alter table clients auto_increment = 1", nativeQuery = true)
    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity deleteClient(@PathVariable(value = "id") int idClient)
            throws AccessDeniedException {
        clientService.deleteById(idClient);
        return ResponseEntity.ok().build();

    }
}
