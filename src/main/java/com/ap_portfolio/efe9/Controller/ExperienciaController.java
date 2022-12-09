package com.ap_portfolio.efe9.Controller;


import com.ap_portfolio.efe9.Dto.DtoExperiencia;
import com.ap_portfolio.efe9.Entity.Experiencia;
import com.ap_portfolio.efe9.Security.Controller.Mensaje;
import com.ap_portfolio.efe9.Service.ImplExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://mgbfrontend.web.app")
public class ExperienciaController {
    @Autowired
    ImplExperienciaService implExperienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = implExperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!implExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = implExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!implExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        implExperienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExperiencia){      
        if(StringUtils.isBlank(dtoExperiencia.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(implExperienciaService.existsByNombreEmpresa(dtoExperiencia.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(
                dtoExperiencia.getNombreEmpresa(), 
                dtoExperiencia.getDescripcionExperiencia(), 
                dtoExperiencia.getAnioDesde(), 
                dtoExperiencia.getMesDesde(),
                dtoExperiencia.getAnioHasta(), 
                dtoExperiencia.getMesHasta(),
                dtoExperiencia.getEsActual()
        );
        implExperienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia){
        //busca el id de empresa
        if(!implExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("ID de experiencia no existe"), HttpStatus.BAD_REQUEST);
        
        //busca y compara el nombre de la empresa
        if(implExperienciaService.existsByNombreEmpresa(dtoExperiencia.getNombreEmpresa()) && implExperienciaService.getByNombreEmpresa(dtoExperiencia.getNombreEmpresa()).get().getIdExperiencia() != id)
            return new ResponseEntity(new Mensaje("Nombre de la empresa ya existe"), HttpStatus.BAD_REQUEST);
        
        //comprueba que nombre del empresa no sea vacio 
        if(StringUtils.isBlank(dtoExperiencia.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre de la empresa es requerido"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = implExperienciaService.getOne(id).get();
        experiencia.setNombreEmpresa(dtoExperiencia.getNombreEmpresa());
        experiencia.setDescripcionExperiencia((dtoExperiencia.getDescripcionExperiencia()));
        experiencia.setAnioDesde(dtoExperiencia.getAnioDesde());
        experiencia.setMesDesde(dtoExperiencia.getMesDesde());
        experiencia.setAnioHasta(dtoExperiencia.getAnioHasta());
        experiencia.setMesHasta(dtoExperiencia.getMesHasta());
        experiencia.setEsActual(dtoExperiencia.getEsActual());
        
        implExperienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}


