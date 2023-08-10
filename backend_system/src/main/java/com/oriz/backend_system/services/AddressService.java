package com.oriz.backend_system.services;

import com.oriz.backend_system.model.Address;

public interface AddressService {
    Address getAddressById(Long id);

    Address addAddress(Address address);

    Address updateAddress(Long id, Address address);

    void deleteAddress(Long id);

    // Add methods for Address-related operations
}
