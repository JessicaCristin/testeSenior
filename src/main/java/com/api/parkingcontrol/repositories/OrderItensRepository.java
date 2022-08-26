package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.model.OrderItensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface OrderItensRepository extends JpaRepository<OrderItensModel, UUID>{

}
