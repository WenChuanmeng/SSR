package com.sr.searchroom.repository;

import com.sr.searchroom.entity.SupportAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 温小萌 on 2018/11/19
 */
public interface SupportAddressRepository extends JpaRepository<SupportAddress, Long> {
    List<SupportAddress> findSupportAddressesByLevel(String level);
    List<SupportAddress> findSupportAddressesByBelongToAndLevel(String belongTo, String level);
}
