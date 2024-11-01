package com.lyj.securitydomo.dto;
import lombok.*;
import com.lyj.securitydomo.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Builder
    public class RoleDTO{
        private Long roleId;      // 역할 고유 ID
        private String roleName;   // 역할 이름

        // 엔티티에서 DTO로 변환하는 메서드
        public static RoleDTO fromEntity(Role role) {
            return RoleDTO.builder()
                    .roleId(role.getRoleId())
                    .roleName(role.getRole_name())
                    .build();
        }

        // DTO에서 엔티티로 변환하는 메서드
        public Role toEntity() {
            return Role.builder()
                    .roleId(this.roleId)
                    .role_name(this.roleName)
                    .build();
        }
    }

