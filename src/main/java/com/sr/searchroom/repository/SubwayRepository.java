package com.sr.searchroom.repository;

import com.sr.searchroom.entity.Subway;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 温小萌 on 2018/11/21
 */
public interface SubwayRepository extends JpaRepository<Subway, Long> {
    List<Subway> findSubwaysByCityEnName(String cityEnName);
}
