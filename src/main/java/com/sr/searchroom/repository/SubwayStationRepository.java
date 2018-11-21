package com.sr.searchroom.repository;

import com.sr.searchroom.entity.SubwayStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 温小萌 on 2018/11/21
 */
public interface SubwayStationRepository extends JpaRepository<SubwayStation, Long> {
    List<SubwayStation> findSubwayStationsBySubwayId(Long subwayId);
}
