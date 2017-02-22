package net.anjero.chat.module.message.mapper;

import java.util.List;
import net.anjero.chat.module.message.pojo.ChatMessage;
import net.anjero.chat.module.message.pojo.ChatMessageExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ChatMessageMapper {
    int countByExample(ChatMessageExample example);

    int deleteByExample(ChatMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChatMessage record);

    int insertSelective(ChatMessage record);

    List<ChatMessage> selectByExampleWithBLOBsWithRowbounds(ChatMessageExample example, RowBounds rowBounds);

    List<ChatMessage> selectByExampleWithBLOBs(ChatMessageExample example);

    List<ChatMessage> selectByExampleWithRowbounds(ChatMessageExample example, RowBounds rowBounds);

    List<ChatMessage> selectByExample(ChatMessageExample example);

    ChatMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByExample(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKeyWithBLOBs(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);
}