package com.security.basicsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 인가 정책
        http.authorizeRequests()
                .anyRequest()
                .authenticated();

        // 인증 정책
        http.formLogin()
                // 사용자 정의 로그인 페이지
                .loginPage("/loginPage")

                // 로그인 성공 후 이동 페이지
                // 이 경로는 누구나 접근 가능하도록 해야 한다.
                .defaultSuccessUrl("/")

                // 로그인 실패 후 이동 페이지
                .failureUrl("/login")

                // 아이디 파라미터명 설정
                .usernameParameter("userId")

                // 패스워드 파라미터명 설정
                .passwordParameter("passwd")

                // 로그인 Form Action Url
                .loginProcessingUrl("/login_proc")

                // 로그인 성공 후 핸들러
                // AuthenticationSuccessHandler
                .successHandler((request, response, auth) -> {
                    System.out.println("authentication : " + auth.getName());
                    response.sendRedirect("/");
                })

                // 로그인 실패 후 핸들러
                //AuthenticationFailureHandler
                .failureHandler((request, response, exception) -> {
                    System.out.println("exception : " + exception.getMessage());
                    response.sendRedirect("/login");
                })
                .permitAll();
    }
}
