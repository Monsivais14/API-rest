package com.monsi.contactos.service;

import com.monsi.contactos.entity.Contacto;

import java.util.List;

public interface ContactoService {

    public List<Contacto> findAllContact();
    public Contacto findbyid(Long id);
    public Contacto saveContacto(Contacto contacto);
    public void delete(Long id);

}
