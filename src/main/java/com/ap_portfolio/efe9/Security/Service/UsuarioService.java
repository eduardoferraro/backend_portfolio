
package com.ap_portfolio.efe9.Security.Service;

import com.ap_portfolio.efe9.Security.Entity.Usuario;
import com.ap_portfolio.efe9.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario( String nombreUsuario ) {
        return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public Boolean existsByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public Boolean existsByEmail(String email) {
        return iUsuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario) {
        iUsuarioRepository.save(usuario);
    }
    
    
    
    
}
