package com.lyj.securitydomo.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //시큐리티를 사용하도록 해주는 어노테이션 //진짜 중요함 이 어노테이션 쓰면 시큐리티 필터체인 함수가 나옴
@RequiredArgsConstructor
public class CustomSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { //@EnableWebSecurty 로 인해 불러와짐.
        //누가 어떤 자원을 쓸 수 있고 로그인 로그아웃 처리를 어떻게 할 것인가를 설정하는 부분
        //권한부여 부분
        return http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable()) //위조 방지
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.disable()) //권한과 관련된 설정
                .authorizeHttpRequests(authorizeHttpRequestsConfigurer -> authorizeHttpRequestsConfigurer
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                .requestMatchers("/login", "/board/**", "/user/**", "/","/all").permitAll() //보드에 모든 영역은 지금 누구나 접근 가능한 상태
                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated())

        //로그인 처리
                .formLogin(formLoginConfigurer -> formLoginConfigurer
                    .loginPage("/user/login") //기본 로그인 폼을 사용하지 않고 이 경로의 폼 사용하겠다.
                    .loginProcessingUrl("/loginProcess") //로그인 처리를 하는 URL을 적어주면 알아서 처리해줌.
                    .usernameParameter("username") //파라메타를 무엇을 사용할 것인가?
                    .passwordParameter("password")  //파라메타를 무엇을 사용할 것인가?
                    .defaultSuccessUrl("/") //정상적으로 로그인 처리되면 여기로 가라.
                    .permitAll()) //로그인 폼은 누구나 갈 수 있게 된다.
        //로그아웃 처리
                .logout(logoutConfigurer -> logoutConfigurer
                    .logoutUrl("/logout") //이 URL로 가서 로그아웃 처리(하지만 우리가 설정 하지않고 시큐리티가 알아서 해준다.)
                    .logoutSuccessUrl("/") // 로그아웃 후 가야할 페이지 경로
                    .invalidateHttpSession(true) //세션값 초기화
                    .clearAuthentication(true)) //어센티케이션 초기화
                .build();
    }


    @Bean // password를 암호화 하는 빈
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean //자원들을 시큐리티로 걸러지면 안되니까
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring() // 모든 스태틱 자원 필터 제외
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()); //이렇게 해주면 스태틱에 있는 모든 자원들을 필터체인에 걸지 않는다(필터에서 제외)
        //.requestMatchers("/static/**");
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, //이 함수는 인증관리자 하나를 리턴
                                                       BCryptPasswordEncoder bCryptPasswordEncoder, //암호화 빈
                                                       UserDetailsService userDetailsService, AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        AuthenticationManagerBuilder builder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder); //패스워드 인코딩
        return builder.build();
    }
}