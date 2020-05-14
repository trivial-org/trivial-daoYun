package org.fzu.cs03.daoyun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.fzu.cs03.daoyun.entity.AttendActivity;
import org.fzu.cs03.daoyun.entity.PublishedActivity;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/12 20:06
 */

@Repository
public interface ActivityMapper extends BaseMapper<AttendActivity> {


}
