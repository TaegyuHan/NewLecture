package co.kr.rlandboot3project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 45)
    @Column(name = "username", length = 45)
    private String username;

    @Size(max = 145)
    @Column(name = "pwd", length = 145)
    private String pwd;

    @Size(max = 45)
    @Column(name = "email", length = 45)
    private String email;

    @ColumnDefault("current_timestamp()")
    @Column(name = "reg_date")
    private Instant regDate;

}