package net.anjero.chat.task.controller;

import net.anjero.common.spring.MediaType;
import net.anjero.common.spring.controller.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 任务类
 * <p>Create by 2017/1/17</p>
 * <p>
 * 作为一个真正的程序员，首先应该尊重编程，<br/>
 * 热爱你所写下的程序，他是你的伙伴，而不是工具。</p>
 *
 * @author :Anjero
 * @version :1.0
 */

@Controller
@RequestMapping("/admin/api/chat/task")
public class ChatTaskApiController extends BaseAdminController {


    private static final long serialVersionUID = 4946301176380005144L;


    @RequestMapping(value = "/page", produces = MediaType.JSON_UTF_8)
    public String page() {
        return "";
    }

}
