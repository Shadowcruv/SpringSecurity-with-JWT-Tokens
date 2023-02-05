package com.eonAcademy.demy2.security;

import com.eonAcademy.demy2.auth.ApplicationUserService;
import com.eonAcademy.demy2.jwt.JwtTokenFilter;
import com.eonAcademy.demy2.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityUserPasswordConfig extends WebSecurityConfigurerAdapter {

   private final PasswordEncoder passwordEncoder;
   private final ApplicationUserService applicationUserService;

   @Autowired
    public SecurityUserPasswordConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
       this.applicationUserService = applicationUserService;
   }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
           http
                   .csrf().disable()
                   .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                   .and()
                   .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                   .addFilterAfter(new JwtTokenFilter(), JwtUsernameAndPasswordAuthenticationFilter.class)
                   .authorizeRequests()
                   .antMatchers("/api/students/building","/")
                   .permitAll()
              //   .antMatchers("/api/students/**").hasRole(STUDENT.name())
                   .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(ForUserPermissions.STUDENT_WRITE.getPermission())
                 /*.antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ForUserPermissions.COURSES_WRITE.getPermission())
                   .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(ForUserPermissions.COURSES_WRITE.getPermission())
                   .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
*/

                   .anyRequest()
                   .authenticated();
                /* .and()
                   .formLogin()
                   .loginPage("/login").permitAll()
                   .defaultSuccessUrl("/management/api/student",true)
                   .and()
                   .rememberMe().tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
                   .key("hvyv")
                   .and()
                   .logout()
                   .logoutUrl("/logout")
                   .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                  // .clearAuthentication(true)
                   .invalidateHttpSession(true)
                //   .deleteCookies("JSESSIONID","remember-me")
                   .logoutSuccessUrl("/login");


                */

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
       DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
       provider.setPasswordEncoder(passwordEncoder);
       provider.setUserDetailsService(applicationUserService);

       return provider;
    }

/*
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails annasmith = User.builder()
                .username("anna")
                .password(passwordEncoder.encode("password1"))
             //   .roles(STUDENT.name())
                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        UserDetails lindaIkeji = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password123"))
               // .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();


        UserDetails emmaIkeji = User.builder()
                .username("emma")
                .password(passwordEncoder.encode("password12"))
               // .roles(ADMINTRAINEE.name())
                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(annasmith,lindaIkeji,emmaIkeji );
    }
 */

}
