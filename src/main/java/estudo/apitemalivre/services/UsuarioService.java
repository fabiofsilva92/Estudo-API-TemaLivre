package estudo.apitemalivre.services;

import estudo.apitemalivre.entities.Usuario;
import estudo.apitemalivre.entities.UsuarioCustomUserDetails;
import estudo.apitemalivre.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorLogin(String login){
        Optional<Usuario> usuario = usuarioRepository.findByLogin(login);

        if(usuario.isEmpty()){
            throw new RuntimeException("Usuário não encontrado");
        }

        return usuario.get();
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return new UsuarioCustomUserDetails(buscarPorLogin(login));
    }

    public Usuario buscarUsuarioPorID(Long idUsuario) {
        Optional<Usuario> byId = usuarioRepository.findById(idUsuario);
        if(byId.isEmpty()) throw new RuntimeException("Usuário não encontrado no findbyid");

        return byId.get();
    }
}
