package org.example.repo;
import org.example.models.Client;
import org.example.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    List<Object> findByName(String name);

    @Query(value = "SELECT c FROM Client c " +
            "JOIN Order o ON o.clientId = c.id " +
            "JOIN Manager m ON o.managerId =:id" )
    List<Client> findClientsByManager(@Param(value="id")Integer id);

    Manager findManagerById(Integer id);
}

