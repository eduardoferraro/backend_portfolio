
package com.ap_portfolio.efe9.Repository;

import com.ap_portfolio.efe9.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombreEmpresa(String nombreEmpresa);
    public boolean existsByNombreEmpresa(String nombreEmpresa);
    
}
