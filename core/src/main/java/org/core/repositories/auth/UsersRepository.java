package org.core.repositories.auth;

import org.core.entities.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    User deleteUserByUsername(String username);
}
