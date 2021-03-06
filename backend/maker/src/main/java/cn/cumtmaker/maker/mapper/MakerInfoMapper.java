package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.MakerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

@Mapper
public interface MakerInfoMapper {
    int makerSignUpInfo(@Param("userId") int userId, @Param("storeId")int storeId,
                        @Param("storeName") String storeName, @Param("mobileNumber") String mobileNumber,
                        @Param("email") String email, @Param("school") String school,
                        @Param("realName") String realName,@Param("studentId") String studentId,
                        @Param("registrationTime") Timestamp registrationTime);
    MakerInfo getMakerInfo(int userId);
    int updateMakerInfo(@Param("userId") int userId, @Param("storeName") String storeName,
                        @Param("mobileNumber") String mobileNumber,
                        @Param("email") String email, @Param("school") String school,
                        @Param("realName") String realName,@Param("studentId") String studentId);
}