package com.ap_portfolio.efe9.Security.Repository;

import com.ap_portfolio.efe9.Security.Entity.Rol;
import com.ap_portfolio.efe9.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre( RolNombre rolNombre);
    
}
