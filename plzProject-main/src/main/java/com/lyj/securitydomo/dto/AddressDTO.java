package com.lyj.securitydomo.dto;

import com.lyj.securitydomo.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class AddressDTO {
        private Long addressId;  // 주소 고유 ID
        private int userId;      // 사용자 ID
        private String city;     // 도시명 (예: 서울)
        private String state;    // 구명 (예: 강남구)

        // 엔티티에서 DTO로 변환하는 메서드
        public static AddressDTO fromEntity(Address address) {
            return AddressDTO.builder()
                    .addressId(address.getAddressId())
                    .userId(address.getUser_id())
                    .city(address.getCity())
                    .state(address.getState())
                    .build();
        }

        // DTO에서 엔티티로 변환하는 메서드
        public Address toEntity() {
            return Address.builder()
                    .addressId(this.addressId)
                    .user_id(this.userId)
                    .city(this.city)
                    .state(this.state)
                    .build();
        }
    }

