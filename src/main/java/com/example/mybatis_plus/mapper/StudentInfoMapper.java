package com.example.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_plus.domain.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {
    List<StudentInfo> findAllForXml(StudentInfo studentInfo);

    int insertForXml(StudentInfo studentInfo);

    int updateByIdForXml(StudentInfo studentInfo);

    int insertBatchForXml(List<StudentInfo> studentInfos);

    @Select("select max(user_id) from student_info")
    int getMaxUserId();

    int insertBatchUseArrayForXml(List<Object[]> studentInfos);
}
