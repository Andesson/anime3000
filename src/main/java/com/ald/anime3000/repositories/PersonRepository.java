package com.ald.anime3000.repositories;

import com.ald.anime3000.models.person.PersonModel;
import com.ald.anime3000.models.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonModel, UUID> {
}
