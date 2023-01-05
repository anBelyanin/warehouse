package org.core.repositories.auth;

import org.core.entities.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreRolesRepository extends JpaRepository<Role, Long> {

}
