package com.sr.searchroom.service.user;

import com.sr.searchroom.entity.Subway;
import com.sr.searchroom.entity.SubwayStation;
import com.sr.searchroom.entity.SupportAddress;
import com.sr.searchroom.repository.SubwayRepository;
import com.sr.searchroom.repository.SubwayStationRepository;
import com.sr.searchroom.repository.SupportAddressRepository;
import com.sr.searchroom.service.IAddressService;
import com.sr.searchroom.service.ServiceMultiResult;
import com.sr.searchroom.web.dto.SubwayDTO;
import com.sr.searchroom.web.dto.SubwayStationDTO;
import com.sr.searchroom.web.dto.SupportAddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 温小萌 on 2018/11/19
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @Autowired
    private SubwayRepository subwayRepository;

    @Autowired
    private SubwayStationRepository subwayStationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiceMultiResult<SupportAddressDTO> getSupportCities() {
        List<SupportAddress> supportAddresses = supportAddressRepository.findSupportAddressesByLevel(SupportAddress.Level.CITY.getValue());
        List<SupportAddressDTO> supportAddressDTOS = new ArrayList<SupportAddressDTO>();
        if (null != supportAddresses && !supportAddresses.isEmpty()) {

            for (SupportAddress supportAddress : supportAddresses) {
                SupportAddressDTO target = modelMapper.map(supportAddress, SupportAddressDTO.class);
                supportAddressDTOS.add(target);
            }
        }

        return new ServiceMultiResult(supportAddressDTOS.size(), supportAddressDTOS);
    }

    @Override
    public ServiceMultiResult<SupportAddressDTO> getSupportRegions(String cityName) {

        List<SupportAddress> supportAddresses = supportAddressRepository.findSupportAddressesByBelongToAndLevel(cityName, SupportAddress.Level.REGION.getValue());
        List<SupportAddressDTO> supportAddressDTOS = new ArrayList<>();
        if (null != supportAddresses && !supportAddresses.isEmpty()) {
            for (SupportAddress supportAddress : supportAddresses) {
                SupportAddressDTO supportAddressDTO = modelMapper.map(supportAddress, SupportAddressDTO.class);
                supportAddressDTOS.add(supportAddressDTO);
            }
        }

        return new ServiceMultiResult<>(supportAddressDTOS.size(), supportAddressDTOS);
    }

    @Override
    public ServiceMultiResult<SubwayDTO> getSubways(String cityName) {

        List<Subway> subways = subwayRepository.findSubwaysByCityEnName(cityName);
        List<SubwayDTO> subwayDTOS = new ArrayList<>();
        if (null != subways && !subways.isEmpty()) {
            for (Subway subway : subways) {
                SubwayDTO target = modelMapper.map(subway, SubwayDTO.class);
                subwayDTOS.add(target);
            }
        }
        return new ServiceMultiResult<>(subwayDTOS.size(), subwayDTOS);
    }

    @Override
    public ServiceMultiResult<SubwayStationDTO> getSubwayStations(Long subwayId) {

        List<SubwayStation> subwayStations = subwayStationRepository.findSubwayStationsBySubwayId(subwayId);
        List<SubwayStationDTO> subwayStationDTOS = new ArrayList<>();
        if (null != subwayStations && !subwayStations.isEmpty()) {
            for (SubwayStation subwayStation : subwayStations) {
                SubwayStationDTO subwayStationDTO = modelMapper.map(subwayStation, SubwayStationDTO.class);
                subwayStationDTOS.add(subwayStationDTO);
            }
        }
        return new ServiceMultiResult<>(subwayStationDTOS.size(), subwayStationDTOS);
    }
}
