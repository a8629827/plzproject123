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

    }

