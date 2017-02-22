package net.anjero.common.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by tengshaojun on 2015/11/12.
 */
public class PhotoFileUtil {
    /**
     * 图片上传
     *
     * @param file          文件
     * @param rootPath     根路径
     * @param subPath      子路径
     * @param isCompress    是否压缩  true 压缩  false 不压缩 ，压缩时下面参数都为必填项
     * @param width         宽
     * @param height        高
     * @param gp            是否等比压缩  true 是 false 否      @return
     */
    public static Map uploadFile(CommonsMultipartFile file, String rootPath, String subPath, Boolean isCompress, Integer width, Integer height, Boolean gp) {
        Map map = new HashMap();
        String error = "";
        if (isCompress) {
            if (width == null || width == 0) error += "【宽度】";
            if (height == null || height == 0) error += "【高度】";
            if (!StringUtils.isEmpty(error)) error = "请设置图片要压缩的" + error;
        }
        if (!StringUtils.isEmpty(error)) {
            map.put("error", error);
            return map;
        }

        String uploadpath =  rootPath+subPath;
        createDir(uploadpath);  //上传文件存放的文件夹
        String path = "";
        String compressPath = "";
        try {
            if (file != null) {
                String imgName = getRandomFileName(file.getOriginalFilename());
                FileOutputStream fileOS = new FileOutputStream(uploadpath + imgName);
                fileOS.write(file.getBytes());
                fileOS.close();
                path = subPath + imgName;
                if (isCompress) {
                    String compressImgName = "compress_" + imgName;
                    CompressPhotoFile mypic = new CompressPhotoFile();
                    mypic.compressPic(uploadpath, uploadpath, imgName, compressImgName, width, height, gp);
                    compressPath =  subPath + compressImgName;
                }
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        }
        map.put("path", path);
        map.put("compressPath", compressPath);
        return map;
    }

    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            return false;
        } else {
            if (!destDirName.endsWith(File.separator)) {
                destDirName = destDirName + File.separator;
            }
            return dir.mkdirs();
        }
    }

    public static String getRandomFileName(String filename) {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "") + getFileNameSufix(filename);
    }

    public static String getFileNameSufix(String filename) {
        int n = filename.lastIndexOf(".");
        return filename.substring(n, filename.length()).toLowerCase();
    }
}
