package com.ap_portfolio.efe9.Controller;


import com.ap_portfolio.efe9.Dto.DtoProyecto;
import com.ap_portfolio.efe9.Entity.Proyecto;
import com.ap_portfolio.efe9.Security.Controller.Mensaje;
import com.ap_portfolio.efe9.Service.ImpProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://mgbfrontend.web.app")
public class ProyectoController {
    @Autowired
    ImpProyectoService impProyectoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = impProyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!impProyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = impProyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        impProyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto){      
        if(StringUtils.isBlank(dtoProyecto.getNombreProyecto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impProyectoService.existsByNombreProyecto(dtoProyecto.getNombreProyecto()))
            return new ResponseEntity(new Mensaje("Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(
            dtoProyecto.getNombreProyecto(),
            dtoProyecto.getDescripcionProyecto(),
            dtoProyecto.getAnio(),
            dtoProyecto.getLinkProyecto()              
        );
        impProyectoService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto){
        //busca el id 
        if(!impProyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("ID no existe"), HttpStatus.BAD_REQUEST);
        
        //busca y compara el nombre
        if(impProyectoService.existsByNombreProyecto(dtoProyecto.getNombreProyecto()) && impProyectoService.getByNombreProyecto(dtoProyecto.getNombreProyecto()).get().getIdProyecto() != id)
            return new ResponseEntity(new Mensaje("Nombre de la habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        //comprueba que los campos no sean vacios
        if(StringUtils.isBlank(dtoProyecto.getNombreProyecto()))
            return new ResponseEntity(new Mensaje("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        
         if(StringUtils.isBlank(dtoProyecto.getDescripcionProyecto()))
            return new ResponseEntity(new Mensaje("La descripcion del proyecto es requerida"), HttpStatus.BAD_REQUEST);
        
        
        if(StringUtils.isBlank(dtoProyecto.getAnio()))
            return new ResponseEntity(new Mensaje("El año del proyecto es requerido"), HttpStatus.BAD_REQUEST);
        
        
        if(StringUtils.isBlank(dtoProyecto.getLinkProyecto()))
            return new ResponseEntity(new Mensaje("El link del proyecto es requerido"), HttpStatus.BAD_REQUEST);
        
        
        Proyecto proyecto = impProyectoService.getOne(id).get();
        proyecto.setNombreProyecto(dtoProyecto.getNombreProyecto());
        proyecto.setDescripcionProyecto(dtoProyecto.getDescripcionProyecto());
        proyecto.setAnio(dtoProyecto.getAnio());
        proyecto.setLinkProyecto(dtoProyecto.getLinkProyecto());
        
        
        
        impProyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
             
    }
}


