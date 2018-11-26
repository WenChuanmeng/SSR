package com.sr.searchroom.repository;

import com.sr.searchroom.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 温小萌 on 2018/11/26
 */
public interface HouseRepository extends JpaRepository<House, Long> {
}
