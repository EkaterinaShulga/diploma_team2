package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.User;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    Collection<User> getAll();

    @Query(value = "SELECT * FROM users WHERE password = :password", nativeQuery = true)
    User getUserByPassword(String password);
    
    public Optional<User> findByEmail(String userLogin);

    @Query(value = "SELECT * FROM users WHERE first_name = :firstName AND last_name = :lastName", nativeQuery = true)
    Optional<User> getUserByFirstNameAndLastName(String firstName, String lastName);
}