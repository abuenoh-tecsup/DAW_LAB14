package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Role;
import com.tecsup.demo.domain.entities.Usuario;
import com.tecsup.demo.domain.persistence.IUsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioDao usuarioDao;

    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null) {
            logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
            throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Role role : usuario.getRoles()) {
            logger.info("Role: ".concat(role.getAuthority()));
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        if (grantedAuthorities.isEmpty()) {
            logger.error("Error en el login: Usuario '"+username+"' no tiene roles asignados!");
            throw new UsernameNotFoundException("Usuario: " + username + " no tiene roles asignados!");
        }

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, grantedAuthorities);
    }
}
