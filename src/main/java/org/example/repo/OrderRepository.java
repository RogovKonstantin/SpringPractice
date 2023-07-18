package org.example.repo;
import org.example.models.Device;
import org.example.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findOrderById(Integer id);
    @Query(value = "SELECT d FROM Device d " +
            "JOIN OrderList ol ON ol.deviceId = d.id " +
            "JOIN Order o ON ol.orderId =:id" )
    List<Device> findAllDevicesByOrder(@Param(value = "id") Integer id);
}
