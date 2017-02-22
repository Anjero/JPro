package net.anjero.pro.module.dashboard;

import net.anjero.common.spring.controller.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anjero on 16/8/29.
 */

@Controller
@RequestMapping("/admin")
public class DashboardController extends BaseAdminController {

    private static final long serialVersionUID = -1965372760212266661L;


    @RequestMapping("/dashboard")
    public String dashboard(){
        return "admin/dashborad";
    }
}
