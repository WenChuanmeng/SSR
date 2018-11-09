package com.sr.searchroom.repository;

import com.sr.searchroom.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 温小萌 on 2018/11/9
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    public List<Role> getByUserId(Long userId);
}
