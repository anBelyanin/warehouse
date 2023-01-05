package org.core.repositories.auth;

import org.core.entities.auth.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersAuthoritiesRepository extends JpaRepository<UserAuthority, Long> {

}
