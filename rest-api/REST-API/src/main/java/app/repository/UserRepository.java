/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repository;

import java.util.List;
import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pedro
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
   List<User> findByName(String name);
   User findByUsername(String username);
   List<User> findByType(String type);
}
