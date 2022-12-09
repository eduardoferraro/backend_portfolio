
package com.ap_portfolio.efe9.Repository;

import com.ap_portfolio.efe9.Entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Integer>{
    public Optional<Habilidad> findByNombreHabilidad(String nombreHabilidad);
    public boolean existsByNombreHabilidad(String nombreHabilidad);
    
}
