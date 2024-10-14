package com.DB.orderScheduler.services.impl;

import com.DB.orderScheduler.dto.UserDTO;
import com.DB.orderScheduler.models.RoleEntity;
import com.DB.orderScheduler.models.RoleType;
import com.DB.orderScheduler.models.UserModel;
import com.DB.orderScheduler.repositories.RoleRepository;
import com.DB.orderScheduler.repositories.UserRepository;
import com.DB.orderScheduler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserModel, Long> implements UserService {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected RoleRepository roleRepository;

    @Override
    public List<UserModel> search(String filter) throws Exception {
        try {
            List<UserModel> usersSearch = userRepository.search(filter);
            return usersSearch;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<UserModel> search(String filter, Pageable pageable) throws Exception {
        try {
            Page<UserModel> usersSearch = userRepository.search(filter, pageable);
            return usersSearch;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<UserModel> findByEmail(String email) throws Exception {
        try {
            Optional<UserModel> userSearched = userRepository.findByEmail(email);
            return userSearched;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Optional<UserModel> addRoleToUser(String email, RoleType roleType) {
        // Buscar el usuario por su email
        Optional<UserModel> userOptional = userRepository.findByEmail(email);
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        UserModel user = userOptional.get();

        // Buscar el rol por su tipo (ADMIN o EMPLEADO_COMUN)
        Optional<RoleEntity> roleOptional = roleRepository.findByType(String.valueOf(roleType));
        if (!roleOptional.isPresent()) {
            throw new IllegalArgumentException("Rol no encontrado");
        }
        RoleEntity role = roleOptional.get();

        // Agregar el rol al usuario si no lo tiene ya
        Set<RoleEntity> roles = user.getRoles();
        if (!roles.contains(role)) {
            roles.add(role);
            user.setRoles(roles);  // Actualizar la colección de roles en el usuario
        }

        // Guardar el usuario con el nuevo rol
        return Optional.of(userRepository.save(user));
    }

    @Override
    public UserModel searchById(Long filter) throws Exception {
        try {
            UserModel userSearched = userRepository.searchById(filter);
            return userSearched;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public UserModel addUser(UserDTO userDTO) {
        UserModel userModel = new UserModel();

        userModel.setEmail(userDTO.getEmail());
        userModel.setName(userDTO.getName());
        userModel.setLastName(userDTO.getLastName());
        userModel.setDni(userDTO.getDni());

        return userRepository.save(userModel);
    }

    @Override
    public UserDTO convertToDTO(UserModel userModel) {
        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(userModel.getEmail());
        userDTO.setName(userModel.getName());
        userDTO.setLastName(userModel.getLastName());
        userDTO.setDni(userModel.getDni());

        return userDTO;
    }
}
