package com.example.TMS.Service;

import com.example.TMS.BaseResponse.BaseResponse;
import com.example.TMS.DTO.VehicleTypeDTO;
import com.example.TMS.EntityORModel.VehicleType;

public interface VehicleTypeServiceInterface {
    VehicleType create(VehicleTypeDTO vehicleTypeDTO);
    BaseResponse getbyid(long id);
    BaseResponse deletebyid(long id);
    BaseResponse putupdate(VehicleTypeDTO vehicleTypeDTO, Long id);
}
