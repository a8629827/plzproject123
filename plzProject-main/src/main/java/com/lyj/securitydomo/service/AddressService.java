package com.lyj.securitydomo.service;

import com.lyj.securitydomo.domain.Address;
import java.util.List;

public interface AddressService {
    Address addAddress(Address address);  // 주소 추가
    Address updateAddress(Long addressId, Address address);  // 주소 수정
    void deleteAddress(Long addressId);  // 주소 삭제
    List<Address> getAddressesByUserId(Long userId);  // 특정 사용자 ID로 주소 조회
}