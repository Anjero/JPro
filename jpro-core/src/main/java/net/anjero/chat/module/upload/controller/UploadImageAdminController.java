package net.anjero.chat.module.upload.controller;

import net.anjero.common.core.exception.ForbiddenJsonException;
import net.anjero.common.spring.MediaType;
import net.anjero.common.spring.controller.BaseAdminController;
import net.anjero.common.util.FileUtil;
import net.anjero.plugins.json.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.UUID;

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

@RequestMapping("/admin/api/upload")
public class UploadImageAdminController extends BaseAdminController {


    @RequestMapping(value = "/image", method = RequestMethod.POST, produces = MediaType.JSON_UTF_8)
    @ResponseBody
    public void upload(@RequestParam CommonsMultipartFile uploadFile, @RequestParam(defaultValue = "keywords") String type
            , HttpServletRequest request, HttpServletResponse response) throws ForbiddenJsonException {
        //TODO 上传文件为zip包,解压后读取文件内容,从关键字开始分析
        ResourceBundle bundle = PropertyResourceBundle.getBundle("analysis");
        String filePath = getcurrentDatetime("yyMMdd");
        String realPath = bundle.getString("analysis.file.catalogue") + "upload/" + filePath + "/";
        Result result;
//        String res = JSONUtils.toJSONString(result)
//        return res;
        String uuid = UUID.randomUUID().toString();
        String savePath = FileUtil.saveFile(uploadFile, realPath, uploadFile.getOriginalFilename());

        result = new Result(200, "s", "");
        returnJson(result, response);
    }


}
