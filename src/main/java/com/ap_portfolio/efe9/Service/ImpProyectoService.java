
package com.ap_portfolio.efe9.Service;

import com.ap_portfolio.efe9.Entity.Proyecto;
import com.ap_portfolio.efe9.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService {
    @Autowired
    IProyectoRepository iProyectoRepository;
    
    public List<Proyecto> list(){
        return iProyectoRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(int idProyecto){
        return iProyectoRepository.findById(idProyecto);
    }
    
    public Optional<Proyecto> getByNombreProyecto(String nombreProyecto){
        return iProyectoRepository.findByNombreProyecto(nombreProyecto);
    }
    
    public void save(Proyecto proyecto){
        iProyectoRepository.save(proyecto);
    }
    
    public void delete(int idProyecto){
        iProyectoRepository.deleteById(idProyecto);
    }
    
    public boolean existsById(int idProyecto){
        return iProyectoRepository.existsById(idProyecto);
    }
    
    public boolean existsByNombreProyecto(String nombreProyecto){
        return iProyectoRepository.existsByNombreProyecto(nombreProyecto);
    }
    
}
