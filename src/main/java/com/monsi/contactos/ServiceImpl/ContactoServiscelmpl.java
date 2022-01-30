package com.monsi.contactos.ServiceImpl;


import com.monsi.contactos.entity.Contacto;
import com.monsi.contactos.repository.ContactoRepository;
import com.monsi.contactos.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ContactoServiscelmpl implements ContactoService {

    @Autowired
    private ContactoRepository repository;

    @Override
    public List<Contacto> findAllContact() {
        return repository.findAll();
    }

    @Override
    public Contacto findbyid(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Contacto saveContacto(Contacto contacto) {
        return repository.save(contacto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
