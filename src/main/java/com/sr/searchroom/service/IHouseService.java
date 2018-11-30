package com.sr.searchroom.service;

import com.sr.searchroom.web.dto.HouseDTO;
import com.sr.searchroom.web.form.HouseForm;

/**
 * Created by 温小萌 on 2018/11/27
 */
public interface IHouseService {

    ServiceResult<HouseDTO> save(HouseForm houseForm);
}
