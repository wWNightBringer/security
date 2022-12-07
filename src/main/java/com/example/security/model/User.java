package com.example.security.model;

import com.example.security.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE User SET isDeleted = 1 WHERE id = ?")
public class User {
  @Id
  @GeneratedValue
  private Integer id;

  @Column(unique = true)
  private String username;

  private String password;

  @Column(unique = true)
  private String email;

  @Enumerated
  private Role role;

  private boolean isDeleted;
}
