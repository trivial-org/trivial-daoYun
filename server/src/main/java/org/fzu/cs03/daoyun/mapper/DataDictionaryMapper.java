package org.fzu.cs03.daoyun.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fzu.cs03.daoyun.entity.DataDirectionary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DataDictionaryMapper {

// 空格:字段实体映射
//    @Insert("INSERT INTO user (role_id, username, password, email, creation_date, is_active, is_deleted) VALUES (#{roleId},#{userName}, #{password}, #{email}, #{createDate}, #{isActive}, #{isDeleted} )")

//    @Select("SELECT username FROM user where email = #{email}")

    @Insert("INSERT INTO data_dictionary (dict_code, dict_name, data_code, data_name, creation_date, is_deleted) VALUES (#{dictCode},#{dictName}, #{dataCode}, #{dataName}, #{createDate}, #{isDeleted} )")
    void insertData(long dictCode, String dictName, long dataCode, String dataName, String createDate, boolean isDeleted);

    @Select("SELECT dict_code, dict_name, data_code, data_name FROM data_dictionary WHERE dict_code = #{dictCode} ")
    List<DataDirectionary> getDataDictionaryByDictCode(long dictCode);

    @Delete("DELETE FROM data_dictionary WHERE dict_code = #{dictCode} and data_code = #{dataCode} ")
    void deleteData(long dictCode, long dataCode);

    @Select("SELECT * FROM (SELECT dict_code, dict_name, data_code, data_name FROM data_dictionary where dict_code = #{dictCode} ) as tmp where tmp.data_name like '%${dataName}%'")
    List<DataDirectionary> getDataDictionaryByDataName(long dictCode,String dataName);

}
