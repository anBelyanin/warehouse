package org.core.repositories.auth;

import org.core.entities.auth.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsersContactRepository extends JpaRepository<UserContact, Long> {

    Set<UserContact> findUserContactByValue(String value);
}
