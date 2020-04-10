package org.fzu.cs03.daoyun.mapper;

import org.apache.ibatis.annotations.*;
import org.fzu.cs03.daoyun.entity.DataDirectionary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RichTextMapper {
    @Insert("INSERT INTO rich_text (rich_text, is_deleted) VALUES ( #{text}, 0 ) ")
    void insertText(String text);

    @Select("SELECT rich_text FROM rich_text WHERE rich_text_id = #{textId}")
    String getText(long textId);

    @Update("UPDATE rich_text SET rich_text = #{text} WHERE rich_text_id = #{textId}")
    void updateText(long textId, String text);

    @Delete("DELETE FROM rich_text WHERE rich_text_id = #{textId} ")
    void deleteText(long textId);

    @Select("SELECT LAST_INSERT_ID()")
    long LAST_INSERT_ID();

    @Select( "SELECT rich_text_id from rich_text order by rich_text_id DESC limit 1" )
    long getLastId();
}
