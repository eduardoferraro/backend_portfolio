package com.ap_portfolio.efe9.Controller;

import com.ap_portfolio.efe9.Dto.DtoPersona;
import com.ap_portfolio.efe9.Entity.Persona;
import com.ap_portfolio.efe9.Security.Controller.Mensaje;
import com.ap_portfolio.efe9.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {

    @Autowired
    ImpPersonaService impPersonaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        Persona persona = impPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona) {
        //busca el id de la persona
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID de persona no existe"), HttpStatus.BAD_REQUEST);
        }

        //busca y compara el nombre de persona
        if (impPersonaService.existsByNombre(dtoPersona.getNombre()) && impPersonaService.getByNombre(dtoPersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Nombre de la persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        //comprueba que los campos  no sean vacios 
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la persona es requerido"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoPersona.getApellido())) {
            return new ResponseEntity(new Mensaje("El apellido de la persona es requerido"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoPersona.getResidencia())) {
            return new ResponseEntity(new Mensaje("Residencia de la persona es requerido"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoPersona.getTelefono())) {
            return new ResponseEntity(new Mensaje("El telefono de la persona es requerido"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoPersona.getEmail())) {
            return new ResponseEntity(new Mensaje("El email de la persona es requerido"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoPersona.getTextoPersona())) {
            return new ResponseEntity(new Mensaje("Acerca de la persona es requerido"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoPersona.getImagenPersona())) {
            return new ResponseEntity(new Mensaje("La imagen de la persona es requerida"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = impPersonaService.getOne(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido((dtoPersona.getApellido()));
        persona.setResidencia(dtoPersona.getResidencia());
        persona.setEdad(dtoPersona.getEdad());
        persona.setEmail(dtoPersona.getEmail());
        persona.setTelefono(dtoPersona.getTelefono());
        persona.setTextoPersona(dtoPersona.getTextoPersona());
        persona.setImagenPersona(dtoPersona.getImagenPersona());

        impPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);

    }

}
