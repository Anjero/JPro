package net.anjero.chat.module.message.service;

import net.anjero.chat.module.message.mapper.ChatMessageMapper;
import net.anjero.chat.module.message.pojo.ChatMessage;
import net.anjero.chat.module.message.pojo.ChatMessageExample;
import net.anjero.plugins.mybaits.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ///////////////////////////////////////
 * <p>Create by 2017/1/17</p>
 * <p>
 * 作为一个真正的程序员，首先应该尊重编程，<br/>
 * 热爱你所写下的程序，他是你的伙伴，而不是工具。
 * </p>
 * ///////////////////////////////////////
 *
 * @author :Anjero
 * @version :1.0
 */

@Service
public class ChatMessageService {


    @Resource
    private ChatMessageMapper chatMessageMapper;

    public Page page(Boolean isRead, int pageNo, int pageSize) {

        ChatMessageExample chatMessageExample = new ChatMessageExample();

        chatMessageExample.setOrderByClause(" in_time desc");

        ChatMessageExample.Criteria criteria = chatMessageExample.createCriteria();
        if (isRead != null)
            criteria.andIsReadEqualTo(isRead);

        int count = chatMessageMapper.countByExample(chatMessageExample);


        chatMessageExample.setLimitStart((pageNo - 1) * pageSize);
        chatMessageExample.setLimitEnd(pageSize);
        List<ChatMessage> chatMessageList = chatMessageMapper.selectByExample(chatMessageExample);
        Page page = new Page(count, pageNo, pageSize, chatMessageList);
        return page;
    }
}
