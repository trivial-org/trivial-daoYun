package org.fzu.cs03.daoyun.mapper;

import org.apache.ibatis.annotations.*;
import org.fzu.cs03.daoyun.entity.Orgnization;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrgnizationMapper {

    @Insert("INSERT INTO org (org_code, org_name, extend_json, creation_date, creator, is_deleted) VALUES (#{ordCode}, #{orgName}, #{richTextId},  #{createDate}, #{creator}, #{isDeleted} )")
    void cerateOrgnization(Long ordCode, String orgName,  Long richTextId, String createDate, String creator, boolean isDeleted);

    @Select("SELECT count(org_id) FROM org WHERE org_code = #{orgCode} limit 1")
    boolean OrgExistByOrgCode(Long orgCode);

    @Select("SELECT count(org_id) FROM org WHERE org_id = #{orgId} limit 1")
    boolean OrgExistByOrgId(Long orgId);

    @Select("SELECT extend_json FROM org WHERE org_code = #{orgCode} ")
    Long geRichTextIdByOrgCode(Long orgCode);

    @Select("SELECT extend_json FROM org WHERE org_id = #{orgId} ")
    Long geRichTextIdByOrgId(Long orgId);

    @Select("SELECT org_code, org_name, extend_json richTextId, creation_date, creator FROM org WHERE org_code = #{orgCode}")
    Orgnization getOrgInfoByOrgCode(Long orgCode);

    @Delete("DELETE FROM org WHERE org_code = #{orgCode}")
    Long deleteOrgnizationByOrgCode(Long orgCode);

    @Delete("DELETE FROM org WHERE org_id = #{orgId}")
    Long deleteOrgnizationByOrgId(Long orgId);

    @Select( "SELECT org_id FROM org WHERE org_code = #{orgCode} limit 1 ")
    Long getOrgIdByOrgCode(Long orgCode);

//    @Select( "SELECT IFNULL ( (SELECT org_code FROM org order by org_id DESC limit 1)  , 0)" )

    @Select( "SELECT org_code FROM org order by org_id DESC limit 1" )
    Long getLastOrgCode();
//    select * from table order by id DESC limit 1

    //获得创建者用户名
    @Select("SELECT creator FROM org WHERE org_code = #{orgId}")
    String getCreatorByOrgId(Long orgId);




}
