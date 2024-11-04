package com.lyj.securitydomo.config.auth;

import lombok.Data;
import com.lyj.securitydomo.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PrincipalDetails implements UserDetails {
    private User user; //composition //유저라는 필드를 가짐

    //
    public PrincipalDetails(User user) {
        this.user = user;
    } //User를 받아서 PrincipalDetails를 생성

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //권한을 얻는 함수이다.
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); //권한들을 얻을 수 있도록 한다.
        authorities.add(() -> {return user.getRole();}); //익명의 함수인데 파라미터는 없고  //실제로 유저에는 롤을 많이 넣을 수 있다.
        return authorities; //권한 정보 리턴
    } //계정이 갖고 있는 권한 목록을 리턴

    @Override
    public String getPassword() { //패스워드를 얻고싶으면

        return user.getPassword();
    }

    @Override
    public String getUsername() { //유저네임을 얻고싶으면

        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
