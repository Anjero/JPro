package net.anjero.pro.module.seo.controller;

import net.anjero.pro.common.spring.controller.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anjero on 16/9/19.
 */

@Controller
@RequestMapping("/admin/seo")
public class SeoAdminController extends BaseAdminController{


    public String index() {
        return "";
    }
}
