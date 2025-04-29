package com.study.springboot.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {
	@Autowired
	public AuthenticationFailureHandler authenticationFailureHandler;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf((csrf) -> csrf.disable())
			.cors((cors) -> cors.disable())
			.authorizeHttpRequests(request -> request
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/").permitAll()
					.requestMatchers("/css/**","/js/**","/images/**").permitAll()
					.requestMatchers("/guest/**").permitAll()
					.requestMatchers("/member/**").hasAnyRole("USER","ADMIN")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated() // 어떠한 요청이라도 인증 필요
			);
		
		// http.formLogin((formLogin) -> formLogin.permitAll()); // 기본 로그인 페이지
		// http.logout((logout) -> logout.permitAll()); // 로그아웃 기본설정 (/logout 으로 인증 해제)
		
		http.formLogin((formLogin) -> formLogin
			.loginPage("/loginForm") // Controller 매핑 주소
			.loginProcessingUrl("/loginCheck") // form 태그 action
			.failureUrl("/loginError?error") // Controller 매핑 주소
			.failureHandler(authenticationFailureHandler)
			.usernameParameter("id") // form 태그 name
			.passwordParameter("passwd") // form 태그 name
			.permitAll()
			);
		
		http.logout((logout) -> logout
			.logoutUrl("/logout")
			.logoutSuccessUrl("/loginForm") // 로그인 성공시 매핑주소
			.permitAll()
			);
		return http.build();
	}

	@Autowired
	private DataSource datasource;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication()
			.dataSource(datasource)
			.usersByUsernameQuery("select id,passwd,enabled from member where id=?") 
			// enabled 의 값이 0이면 비활성, 1이면 활성
			.authoritiesByUsernameQuery("select id,passwd,authority from member where id=?")
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
/*	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.build();
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("1234"))
				.roles("USER","ADMIN")
				.build();
		// 메모리에 사용자 정보를 저장함
		return new InMemoryUserDetailsManager(user,admin);
	}
	
	// 비밀번호 암호화
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
*/	

}
