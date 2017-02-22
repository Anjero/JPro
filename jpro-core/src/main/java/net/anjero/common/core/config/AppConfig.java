package net.anjero.common.core.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * ///////////////////////////////////////
 * <p>Create by 2017/2/22</p>
 * <p>
 * 作为一个真正的程序员，首先应该尊重编程，<br/>
 * 热爱你所写下的程序，他是你的伙伴，而不是工具。
 * </p>
 * ///////////////////////////////////////
 *
 * @author :Anjero
 * @version :1.0
 */
public class AppConfig {


    @Value("")
    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
