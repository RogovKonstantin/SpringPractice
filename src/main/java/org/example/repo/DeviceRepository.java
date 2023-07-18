package org.example.repo;
import org.example.models.Device;
import org.example.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Integer> {
    List<Device> findAllBySerialNumber(String serialNumber);
    Device findDeviceById(Integer id);
    @Query(value = "SELECT o FROM Order o " +
            "JOIN OrderList ol ON ol.orderId = o.id " +
            "JOIN Device d ON ol.deviceId = d.id WHERE d.serialNumber=:serialNumber" )
    List<Order> findOrderWithDevice(@Param(value="serialNumber")String serialNumber);



}
