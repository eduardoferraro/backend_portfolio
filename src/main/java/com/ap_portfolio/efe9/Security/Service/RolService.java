
package com.ap_portfolio.efe9.Security.Service;

import com.ap_portfolio.efe9.Security.Entity.Rol;
import com.ap_portfolio.efe9.Security.Enums.RolNombre;
import com.ap_portfolio.efe9.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre( RolNombre rolNombre ) {
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol) {
        iRolRepository.save(rol);
        
    }
    
}
