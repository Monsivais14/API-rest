package com.monsi.contactos.controller;

import com.monsi.contactos.ServiceImpl.ContactoServiscelmpl;
import com.monsi.contactos.entity.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactoController {

    @Autowired
    public ContactoServiscelmpl serviscelmpl;

    @GetMapping("/")
    public ResponseEntity<List<Contacto>> findAll(){
        return new ResponseEntity<>(serviscelmpl.findAllContact(), HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Contacto> findByid(@PathVariable Long id){
        return new ResponseEntity(serviscelmpl.findbyid(id),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Contacto newContacto){
        return new ResponseEntity(serviscelmpl.saveContacto(newContacto),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        serviscelmpl.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Contacto> update (@RequestBody Contacto contactoActual, @PathVariable("id") Long id){
        Contacto contactoActualizado = serviscelmpl.findbyid(id);
        contactoActualizado.setName(contactoActual.getName());
        contactoActualizado.setLast_name(contactoActual.getLast_name());
        contactoActualizado.setPhone(contactoActual.getPhone());
        return new ResponseEntity<>(serviscelmpl.saveContacto(contactoActualizado), HttpStatus.CREATED);
    }

}
