package com.lyj.securitydomo.service;

import com.lyj.securitydomo.domain.Address;
import com.lyj.securitydomo.domain.User;
import com.lyj.securitydomo.repository.AddressRepository;
import com.lyj.securitydomo.repository.UserRepository;
import com.lyj.securitydomo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Address addAddress(Address address) {
        // 사용자 확인
        Optional<User> user = userRepository.findById(address.getAddress().getUserId());
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        address.setAddress(user.get());  // 사용자 설정
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long addressId, Address address) {
        Optional<Address> existingAddress = addressRepository.findById(addressId);
        if (existingAddress.isEmpty()) {
            throw new IllegalArgumentException("Address not found");
        }
        Address updatedAddress = existingAddress.get();
        updatedAddress.setCity(address.getCity());
        updatedAddress.setState(address.getState());
        return addressRepository.save(updatedAddress);
    }

    @Override
    public void deleteAddress(Long addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Address not found");
        }
        addressRepository.delete(address.get());
    }

    @Override
    public List<Address> getAddressesByUserId(Long userId) {
        return addressRepository.findByUser_UserId(userId);
    }
}