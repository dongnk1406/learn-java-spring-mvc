package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import vn.hoidanit.laptopshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User save(User newUser);

  User findById(long id);

  void deleteById(long id);

  List<User> findByEmail(String email);

  List<User> findByEmailAndAddress(String email, String address);
}