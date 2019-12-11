package com.ftn.isa.service.impl;

import com.ftn.isa.domain.Doctor;
import com.ftn.isa.repository.IDoctorRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class DomainUserDetailsService implements UserDetailsService {

    private final IDoctorRepository _doctorRepository;

    public DomainUserDetailsService(IDoctorRepository doctorRepository){ this._doctorRepository = doctorRepository; }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        Doctor doctorByUsernameFromDataBase = _doctorRepository.findDoctorByEmail(email);

        if (doctorByUsernameFromDataBase == null) {
            throw new UsernameNotFoundException("User" + email + "was not found in the database");
        }

        return createSpringSecurityUser(doctorByUsernameFromDataBase);
    }

    private User createSpringSecurityUser(Doctor doctor){
        List<GrantedAuthority> grantedAuthorities = doctor.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().toString())).collect(Collectors.toList());
        return new User(doctor.getEmail(), doctor.getPassword(), grantedAuthorities);
    }
}
