
package com.ap_portfolio.efe9.Repository;

import com.ap_portfolio.efe9.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreTitulo(String nombreTitulo);
    public boolean existsByNombreTitulo(String nombreTitulo);
    
}
