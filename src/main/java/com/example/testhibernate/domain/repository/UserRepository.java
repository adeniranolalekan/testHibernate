package com.example.testhibernate.domain.repository;

import com.example.testhibernate.domain.entity.User;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA com.hlm.vms.repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByActivationKey(String activationKey);

    List<User> findAllByActivatedIsFalseAndCreatedDateBefore(DateTime dateTime);

    Optional<User> findOneByResetKey(String resetKey);

    Optional<User> findOneByEmail(String email);

    Optional<User> findOneByEmailIgnoreCase(String email);

    @Query("select user from User user where lower(user.email) = ?1 or lower(user.login) = ?1")
    Optional<User> findOneByLogin(String login);
    
    @Query( " select user from User user where"+
    		" user.createdDate >= ?1"+
    		" or user.lastModifiedDate >= ?1 "+
    	    " group by user.id order by user.lastModifiedDate desc")
    List<User> findAllByCreatedDate(DateTime fromDate);
    
    @Query( " select user from User user where"+
    		" user.login = ?1")
    List<User> findAllByLogin(String login);
    
    @Query( " select user from User user where"+
    		" user.lastModifiedDate >= ?1 and user.lastModifiedDate <= ?2"+
    	    " group by user.id order by user.lastModifiedDate desc")
    Page<User> findAllUsersByDate(DateTime fromDate, DateTime toDate,Pageable pageable);
    
    @Query( " select user from User user where"+
    		" user.createdDate >= ?1 and user.createdDate <= ?2"+
    	    " group by user.id order by user.createdDate desc")
    Page<User> findAllUsersByCreatedDate(DateTime fromDate, DateTime toDate,Pageable pageable);
    
    @Query( " select user from User user where"+
    		" user.login = ?1")
    Page<User> findUserByLastLogin(String login,Pageable pageable);
    
    @Query( " select user from User user where"+
    		" lower(user.firstName) like ?1")
    Page<User> findUserByFirstName(String name,Pageable pageable);
    
    @Query( " select user from User user where"+
    		" lower(user.lastName) like ?1")
    Page<User> findUserByLastName(String name,Pageable pageable);
    
    @Query( " select user from User user where"+
    		" lower(user.email) like ?1")
    Page<User> findUserByEmail(String name,Pageable pageable);

    @Override
    void delete(User t);

}
