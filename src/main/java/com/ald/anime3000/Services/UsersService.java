package com.ald.anime3000.Services;

import com.ald.anime3000.enums.StatusUser;
import com.ald.anime3000.models.person.PersonModel;
import com.ald.anime3000.models.user.UserModel;
import com.ald.anime3000.repositories.PersonRepository;
import com.ald.anime3000.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PersonRepository personRepository;

    public UserModel saveUsers(UserModel usersModel){
        try{
            usersModel.setCreateDate(LocalDateTime.now());
            usersModel.setStatusUser(StatusUser.PENDENTE);
        } catch (Exception e){
            usersModel.setStatusUser(StatusUser.ERROR);
        } finally {
            return usersRepository.save(usersModel);
        }
    }

    public Page<UserModel> findAll(Pageable pageable){
        return usersRepository.findAll(pageable);
    }

}
