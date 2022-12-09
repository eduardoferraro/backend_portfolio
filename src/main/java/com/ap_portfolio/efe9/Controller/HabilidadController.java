package com.ap_portfolio.efe9.Controller;


import com.ap_portfolio.efe9.Dto.DtoHabilidad;
import com.ap_portfolio.efe9.Entity.Habilidad;
import com.ap_portfolio.efe9.Security.Controller.Mensaje;
import com.ap_portfolio.efe9.Service.ImpHabilidadService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidad")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontend-ap-386c3.web.app")
public class HabilidadController {
    @Autowired
    ImpHabilidadService impHabilidadService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list(){
        List<Habilidad> list = impHabilidadService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id){
        if(!impHabilidadService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = impHabilidadService.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impHabilidadService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        impHabilidadService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtoHabilidad){      
        if(StringUtils.isBlank(dtoHabilidad.getNombreHabilidad()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impHabilidadService.existsByNombreHabilidad(dtoHabilidad.getNombreHabilidad()))
            return new ResponseEntity(new Mensaje("Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        Habilidad habilidad = new Habilidad(
                dtoHabilidad.getNombreHabilidad(), 
                dtoHabilidad.getCantidadHabilidad()       
        );
        impHabilidadService.save(habilidad);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHabilidad dtoHabilidad){
        //busca el id 
        if(!impHabilidadService.existsById(id))
            return new ResponseEntity(new Mensaje("ID no existe"), HttpStatus.BAD_REQUEST);
        
        //busca y compara el nombre
        if(impHabilidadService.existsByNombreHabilidad(dtoHabilidad.getNombreHabilidad()) && impHabilidadService.getByNombreHabilidad(dtoHabilidad.getNombreHabilidad()).get().getIdHabilidad() != id)
            return new ResponseEntity(new Mensaje("Nombre de la habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        //comprueba que nombre no sea vacio 
        if(StringUtils.isBlank(dtoHabilidad.getNombreHabilidad()))
            return new ResponseEntity(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        
        Habilidad habilidad = impHabilidadService.getOne(id).get();
        habilidad.setNombreHabilidad(dtoHabilidad.getNombreHabilidad());
        habilidad.setCantidadHabilidad((dtoHabilidad.getCantidadHabilidad()));
        
        
        impHabilidadService.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
             
    }
}


