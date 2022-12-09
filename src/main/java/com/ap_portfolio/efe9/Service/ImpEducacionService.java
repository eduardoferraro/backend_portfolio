
package com.ap_portfolio.efe9.Service;

import com.ap_portfolio.efe9.Entity.Educacion;
import com.ap_portfolio.efe9.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService {
    @Autowired
    IEducacionRepository iEducacionRepository;
    
    public List<Educacion> list(){
        return iEducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int idEducacion){
        return iEducacionRepository.findById(idEducacion);
    }
    
    public Optional<Educacion> getByNombreTitulo(String nombreTitulo){
        return iEducacionRepository.findByNombreTitulo(nombreTitulo);
    }
    
    public void save(Educacion educacion){
        iEducacionRepository.save(educacion);
    }
    
    public void delete(int idEducacion){
        iEducacionRepository.deleteById(idEducacion);
    }
    
    public boolean existsById(int idEducacion){
        return iEducacionRepository.existsById(idEducacion);
    }
    
    public boolean existsByNombreTitulo(String nombreTitulo){
        return iEducacionRepository.existsByNombreTitulo(nombreTitulo);
    }
    
}
