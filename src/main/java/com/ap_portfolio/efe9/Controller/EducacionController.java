
package com.ap_portfolio.efe9.Controller;

import com.ap_portfolio.efe9.Dto.DtoEducacion;
import com.ap_portfolio.efe9.Entity.Educacion;
import com.ap_portfolio.efe9.Security.Controller.Mensaje;
import com.ap_portfolio.efe9.Service.ImpEducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontend-ap-386c3.web.app")


public class EducacionController {
    @Autowired
    ImpEducacionService impEducacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = impEducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Educacion educacion = impEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        impEducacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion){      
        if(StringUtils.isBlank(dtoEducacion.getNombreTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impEducacionService.existsByNombreTitulo(dtoEducacion.getNombreTitulo()))
            return new ResponseEntity(new Mensaje("El titulo ya existe"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(
                dtoEducacion.getNombreInstitucion(), 
                dtoEducacion.getNombreTitulo(), 
                dtoEducacion.getAnioDesde(), 
                dtoEducacion.getAnioHasta(), 
                dtoEducacion.getImagenInstitucion()
        );
        impEducacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
        //busca el id de educacion
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("ID de educacion no existe"), HttpStatus.BAD_REQUEST);
        
        //busca y compara el nombre del titulo
        if(impEducacionService.existsByNombreTitulo(dtoEducacion.getNombreTitulo()) && impEducacionService.getByNombreTitulo(dtoEducacion.getNombreTitulo()).get().getIdEducacion() != id)
            return new ResponseEntity(new Mensaje("Nombre del titulo ya existe"), HttpStatus.BAD_REQUEST);
        
        //comprueba que nombre del titulo no sea vacio 
        if(StringUtils.isBlank(dtoEducacion.getNombreTitulo()))
            return new ResponseEntity(new Mensaje("El nombre del titulo es requerido"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = impEducacionService.getOne(id).get();
        educacion.setNombreTitulo(dtoEducacion.getNombreTitulo());
        educacion.setNombreInstitucion((dtoEducacion.getNombreInstitucion()));
        educacion.setAnioDesde(dtoEducacion.getAnioDesde());
        educacion.setAnioHasta(dtoEducacion.getAnioHasta());
        educacion.setImagenInstitucion(dtoEducacion.getImagenInstitucion());
        
        impEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
  
}
    

