package kr.co.rland.boot3.auth.service;

import kr.co.rland.boot3.auth.entity.RlandUserDetails;
import kr.co.rland.boot3.entity.Member;
import kr.co.rland.boot3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RlandUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = Optional.ofNullable(memberRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return RlandUserDetails.builder()
                .username(member.getUsername())
                .password(member.getPwd())
                .authorities(authorities)
                .id(member.getId())
                .email(member.getEmail())
                .build();
    }
}