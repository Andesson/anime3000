package com.ald.anime3000.repositories;

import com.ald.anime3000.models.user.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UsersRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByUsername(String username);

    @Procedure(procedureName = "PROC_ALL_USERS")
    Page<UserModel> getAllUsers(Pageable pageable);
}
