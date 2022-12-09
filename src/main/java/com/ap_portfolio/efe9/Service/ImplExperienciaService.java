
package com.ap_portfolio.efe9.Service;

import com.ap_portfolio.efe9.Entity.Experiencia;
import com.ap_portfolio.efe9.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImplExperienciaService {
     @Autowired
     IExperienciaRepository iExperienciaRepository;
     
     public List<Experiencia> list(){
         return iExperienciaRepository.findAll();
     }
     
     public Optional<Experiencia> getOne(int id){
         return iExperienciaRepository.findById(id);
     }
     
     public Optional<Experiencia> getByNombreEmpresa(String nombreEmpresa){
         return iExperienciaRepository.findByNombreEmpresa(nombreEmpresa);
     }
     
     public void save(Experiencia experiencia){
         iExperienciaRepository.save(experiencia);
     }
     
     public void delete(int id){
         iExperienciaRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iExperienciaRepository.existsById(id);
     }
     
     public boolean existsByNombreEmpresa(String nombreEmpresa){
         return iExperienciaRepository.existsByNombreEmpresa(nombreEmpresa);
     }
}

