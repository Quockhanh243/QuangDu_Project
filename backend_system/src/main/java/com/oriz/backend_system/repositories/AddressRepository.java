package com.oriz.backend_system.repositories;

import com.oriz.backend_system.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
