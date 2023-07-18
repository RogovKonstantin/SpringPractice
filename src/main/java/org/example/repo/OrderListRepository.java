package org.example.repo;
import org.example.models.OrderList;
import org.example.models.OrderListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, OrderListId> {


}
