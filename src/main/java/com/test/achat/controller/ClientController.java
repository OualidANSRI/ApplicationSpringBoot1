package com.test.achat.controller;

import com.test.achat.entity.Client;
import com.test.achat.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    public ClientServiceImpl getClientService() {
        return clientService;
    }

    @RequestMapping(value="createClient", method= RequestMethod.POST)
    public ResponseEntity<Client> createClient(@RequestBody  Client client )
    {
        return ResponseEntity.ok().body(getClientService().create(client));
    }
    @RequestMapping(value="/getAllClients", method=RequestMethod.GET)
    public ResponseEntity getAllClients()
    {
        if(getClientService().count() != 0)
        {
            return ResponseEntity.ok().body(getClientService().findAll());
        }
        return new ResponseEntity("No Client founded", null, HttpStatusCode.valueOf(404));
    }
    @RequestMapping(value="getClient/{id}", method=RequestMethod.GET)
    public ResponseEntity getClient(@PathVariable(value = "id") int id)
    {
        if (getClientService().findById(id).isPresent())
        {
            return ResponseEntity.ok().body(getClientService().findById(id).get());
        }
        return new ResponseEntity("Client "+id+" not found", null, HttpStatusCode.valueOf(404));
    }
    @RequestMapping(value="updateClient/{id}", method=RequestMethod.PUT)
    public ResponseEntity updateClient(@PathVariable(value="id") int id, @RequestBody Client client)
    {
        if (getClientService().findById(id).isPresent())
        {
            client.setId(id);
            return ResponseEntity.ok().body(getClientService().update(client));
        }
        return new ResponseEntity("Client "+id+" not found", null, HttpStatusCode.valueOf(404));
    }
    @DeleteMapping("deleteClient/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") int idClient)
    {
            if(getClientService().findById(idClient).isPresent())
            {
                getClientService().deleteById(idClient);
                return ResponseEntity.ok("Client "+idClient+" deleted successfully !");
            }
            return new ResponseEntity("Client "+idClient+" not found", null, HttpStatusCode.valueOf(404));
    }
    @DeleteMapping("/deleteAllClients")
    public ResponseEntity<String> deleteAllClients()
    {
        if(getClientService().count() != 0)
        {
            getClientService().deleteAll();
            return ResponseEntity.ok().body("All clients deleted successfully !");
        }
        return new ResponseEntity("No Client founded", null, HttpStatusCode.valueOf(404));
    }

}
