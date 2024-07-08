package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByRoleType(UserRole.RoleType roleType);
}
