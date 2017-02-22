package net.anjero.common.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * Created by puqingwen on 2016/5/5.
 */
public class FileUtil {

    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            return false;
        } else {
            return dir.mkdirs();
        }
    }

    public static boolean isFileExists(String fileName) {
        File file = new File(fileName);
        if (file.isFile() && file.exists()) {
            return false;
        }
        return true;
    }

    /**
     * @param destFile
     * @param fileType
     * @author puqingwen
     * @time 2016-5-9 10:01:49
     * @desc 跟进文件路径和文件类型筛选删除
     */
    public static void deleteFile(String destFile, final String fileType) {
        File file = new File(destFile);
        File[] allUnZipFile;
        if (file.isFile()) {
            file.delete();
        } else {
            if (fileType != null) {
                allUnZipFile = file.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(fileType);
                    }
                });

            } else {
                allUnZipFile = file.listFiles();
            }
            if (allUnZipFile != null) {
                for (int i = 0; i < allUnZipFile.length; i++) {
                    allUnZipFile[i].delete();
                }
            }
        }
    }

    public static String saveFile(CommonsMultipartFile orginalFile, String savePath, String fileName) {
        if (orginalFile != null) {// 如果有文章中带有附件
            DataOutputStream out;// 存放文件的绝对路径
            try {
                createDir(savePath);
                out = new DataOutputStream(new FileOutputStream(savePath + fileName));
                InputStream is = null;// 附件输入流
                try {
                    is = orginalFile.getInputStream();
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    out.write(b);
                    return savePath + fileName;
                } catch (IOException exception) {
                    exception.printStackTrace();
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "";
    }

    public static String getMd5ByFile(File file) {
        String value = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

}