package net.anjero.chat.module.message.controller;

import net.anjero.chat.module.message.service.ChatMessageService;
import net.anjero.common.spring.MediaType;
import net.anjero.common.spring.controller.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>polodai Create by 2017/1/17</p>
 * <p>
 * 作为一个真正的程序员，首先应该尊重编程，<br/>
 * 热爱你所写下的程序，他是你的伙伴，而不是工具。</p>
 *
 * @author :Anjero
 * @version :1.0
 * @company:Cheshell
 */

@Controller
@RequestMapping("/admin/api/chat/msg")
public class ChatMsgApiContorller extends BaseAdminController {

    private static final long serialVersionUID = 6777393028932538134L;

    @Resource
    private ChatMessageService service;


    /**
     * 消息列表，类分页
     *
     * @return
     */
    @RequestMapping(value = "/page", produces = MediaType.JSON_UTF_8)
    @ResponseBody
    public String page(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "20") Integer pageSize) {
        return success(200, service.page(false, pageNo, pageSize), "ok");
    }
}
