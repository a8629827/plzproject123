package com.lyj.securitydomo.service;


import com.lyj.securitydomo.dto.UserDTO;

public interface UserService {

        // 사용자 이름으로 사용자 조회
        UserDTO getUserByUsername(String username);

        // 새로운 사용자 생성
        UserDTO createUser(UserDTO userDTO);
    }

