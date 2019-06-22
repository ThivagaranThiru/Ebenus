package com.cours.ebenus.dao;

import java.util.List;

import com.cours.ebenus.entities.Role;

public interface IRoleDao {
	
    public List<Role> findAllRoles();

    public Role findRoleById(int idRole);

    public List<Role> findRoleByIdentifiant(String identifiantRole);

    public Role createRole(Role role);

    public Role updateRole(Role role);

    public boolean deleteRole(Role role);

}
