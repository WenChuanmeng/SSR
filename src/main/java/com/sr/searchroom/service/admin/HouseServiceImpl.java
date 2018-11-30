package com.sr.searchroom.service.admin;

import com.sr.searchroom.base.LoginUserUtil;
import com.sr.searchroom.entity.*;
import com.sr.searchroom.repository.*;
import com.sr.searchroom.service.IHouseService;
import com.sr.searchroom.service.ServiceResult;
import com.sr.searchroom.web.dto.HouseDTO;
import com.sr.searchroom.web.dto.HouseDetailDTO;
import com.sr.searchroom.web.dto.HousePictureDTO;
import com.sr.searchroom.web.form.HouseForm;
import com.sr.searchroom.web.form.PhotoForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 温小萌 on 2018/11/27
 */
@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SubwayRepository subwayRepository;

    @Autowired
    private SubwayStationRepository subwayStationRepository;

    @Autowired
    private HousePictureRepository housePictureRepository;

    @Autowired
    private HouseTagRepository houseTagRepository;

    @Autowired
    private HouseDetailRepository houseDetailRepository;

    @Value(value = "${qiniu.cdn.prefix}")
    private String cdnPrefix;

    @Value(value = "${qiniu.watermark}")
    private String watermark;

    @Transactional
    @Override
    public ServiceResult<HouseDTO> save(HouseForm houseForm) {

        HouseDetail detail = new HouseDetail();
        ServiceResult<HouseDTO> serviceResult = wrapperDetailInfo(detail, houseForm);

        if (null != serviceResult) {
            return serviceResult;
        }
        House house = new House();
        modelMapper.map(houseForm, house);

        Date nowDate = new Date();
        house.setCreateTime(nowDate);
        house.setLastUpdateTime(nowDate);
        house.setAdminId(LoginUserUtil.getAdminId());
        houseRepository.save(house);

        detail.setHouseId(house.getId());

        houseDetailRepository.save(detail);

        List<HousePicture> pictures = generatePicture(houseForm, house.getId());
        List<HousePicture> housePictures = housePictureRepository.save(pictures);

        HouseDTO houseDTO = modelMapper.map(house, HouseDTO.class);
        HouseDetailDTO houseDetailDTO = modelMapper.map(detail, HouseDetailDTO.class);

        houseDTO.setHouseDetail(houseDetailDTO);

        List<HousePictureDTO> housePictureDTOS = new ArrayList<>();

        housePictures.forEach(housePicture -> housePictureDTOS.add(modelMapper.map(housePicture, HousePictureDTO.class)));
        houseDTO.setPictures(housePictureDTOS);
        houseDTO.setCover(this.cdnPrefix + houseDTO.getCover());

        List<String> tags = houseForm.getTags();
        if (null != tags || !tags.isEmpty()) {
            List<HouseTag> houseTags = new ArrayList<>();
            for (String tag : tags) {
                HouseTag houseTag = new HouseTag();

                houseTag.setName(tag);
                houseTag.setHouseId(house.getId());
                houseTags.add(houseTag);
            }

            houseTagRepository.save(houseTags);
            houseDTO.setTags(tags);
        }
        return new ServiceResult<HouseDTO>(true, null, houseDTO);
    }

    private List<HousePicture> generatePicture(HouseForm houseForm, Long houseId) {

        List<HousePicture> housePictures = new ArrayList<>();
        if (null == houseForm.getPhotos() || houseForm.getPhotos().isEmpty()) {
            return housePictures;
        }

        for (PhotoForm photoForm : houseForm.getPhotos()) {
            HousePicture housePicture = new HousePicture();
            housePicture.setHeight(photoForm.getHeight());
            housePicture.setHouseId(houseId);
            housePicture.setWidth(photoForm.getWidth());
            housePicture.setCdnPrefix(cdnPrefix);
            housePicture.setPath(photoForm.getPath() + "?" + watermark);

            housePictures.add(housePicture);
        }

        return housePictures;
    }

    private ServiceResult<HouseDTO> wrapperDetailInfo(HouseDetail detail, HouseForm houseForm) {

        Subway subway = subwayRepository.findOne(houseForm.getSubwayLineId());

        if (null == subway) {
            return new ServiceResult<>(false, "Not found subway line");
        }

        SubwayStation subwayStation = subwayStationRepository.findOne(houseForm.getSubwayStationId());

        if (null == subwayStation || !subway.getId().equals(subwayStation.getSubwayId())) {
            return new ServiceResult<>(false, "Not found subway station");
        }

        detail.setAddress(houseForm.getDetailAddress());
        detail.setDescription(houseForm.getDescription());
        detail.setLayoutDesc(houseForm.getLayoutDesc());
        detail.setRentWay(houseForm.getRentWay());
        detail.setRoundService(houseForm.getRoundService());
        detail.setSubwayLineId(houseForm.getSubwayLineId());
        detail.setSubwayLineName(subway.getName());
        detail.setSubwayStationId(subwayStation.getId());
        detail.setSubwayStationName(subwayStation.getName());
        detail.setTraffic(houseForm.getTraffic());

        return null;
    }
}
