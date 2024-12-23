package kr.co.rland.boot3.repository;

import kr.co.rland.boot3.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
    Member findByUsername(String username);
}
