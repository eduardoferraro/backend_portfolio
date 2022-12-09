
package com.ap_portfolio.efe9.Service;

import com.ap_portfolio.efe9.Entity.Habilidad;
import com.ap_portfolio.efe9.Repository.IHabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpHabilidadService {
     @Autowired
     IHabilidadRepository iHabilidadRepository;
     
     public List<Habilidad> list(){
         return iHabilidadRepository.findAll();
     }
     
     public Optional<Habilidad> getOne(int id){
         return iHabilidadRepository.findById(id);
     }
     
     public Optional<Habilidad> getByNombreHabilidad(String nombreHabilidad){
         return iHabilidadRepository.findByNombreHabilidad(nombreHabilidad);
     }
     
     public void save(Habilidad habilidad){
         iHabilidadRepository.save(habilidad);
     }
     
     public void delete(int id){
         iHabilidadRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iHabilidadRepository.existsById(id);
     }
     
     public boolean existsByNombreHabilidad(String nombreHabilidad){
         return iHabilidadRepository.existsByNombreHabilidad(nombreHabilidad);
     }
}

