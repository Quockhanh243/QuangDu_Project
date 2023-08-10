package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.Address;
import com.oriz.backend_system.repositories.AddressRepository;
import com.oriz.backend_system.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        Optional<Address> existingAddress = addressRepository.findById(id);
        if (existingAddress.isPresent()) {
            Address updatedAddress = existingAddress.get();
            updatedAddress.setFirstName(address.getFirstName());
            updatedAddress.setLastName(address.getLastName());
            updatedAddress.setStreetAddress(address.getStreetAddress());
            updatedAddress.setCity(address.getCity());
            updatedAddress.setState(address.getState());
            updatedAddress.setZipCode(address.getZipCode());
            updatedAddress.setCustomer(address.getCustomer());
            updatedAddress.setMobile(address.getMobile());
            // Set other properties as needed
            return addressRepository.save(updatedAddress);
        }
        return null; // Address ID is missing or not found
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    // Implement methods for Address-related operations
}
