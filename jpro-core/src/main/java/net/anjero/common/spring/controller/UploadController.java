package net.anjero.common.spring.controller;
/* *
 *
 * @Title :UploadController.java
 * @Description:
 * @Datetime : 2014-4-14 下午2:49
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 * @author :anjero
 * @version :1.0
 **/


import net.anjero.common.core.ApplicationListener;
import net.anjero.common.util.CompressPhotoFile;
import net.anjero.common.util.DateUtils;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UploadController extends HttpServlet {


    private final Logger logger = LoggerFactory.getLogger("sys");
    /**
     *
     */
    private static final long serialVersionUID = 7266614062404344373L;

    @Override
    public void init() throws ServletException {
        logger.info("init common upload servlet");
    }

    /**
     * 上传图片
     *
     * @return
     * @author huangjiaping
     * @time 2016-04-18 18:23:00
     * @desc jsonp跨域
     */
    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response) throws ServletException,
            IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html");
        // 保存文件路径
        String filePath = DateUtils.formatDate(new Date(), "yyMMdd");
        String realPath = ApplicationListener.getFileCatalogue() + "upload/" + filePath + "/";
        String imgUrl = ApplicationListener.getFileUrl() + "upload/"
                + filePath + "/";

        // 判断路径是否存在，不存在则创建
        File dir = new File(realPath);
        if (!dir.isDirectory())
            dir.mkdirs();
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory dff = new DiskFileItemFactory();
            dff.setRepository(dir);
            dff.setSizeThreshold(1024000);
            ServletFileUpload sfu = new ServletFileUpload(dff);
            try {
                FileItemIterator fii = null;
                fii = sfu.getItemIterator(request);
                String title = ""; // 图片标题
                String url = ""; // 图片地址
                String fileName = "";
                String state = "SUCCESS";
                while (fii.hasNext()) {
                    FileItemStream fis = fii.next();
                    try {
                        if (!fis.isFormField() && fis.getName().length() > 0) {
                            fileName = fis.getName();
                            Pattern reg = Pattern
                                    .compile("[.]jpg|png|jpeg|pdf|gif$");
                            Matcher matcher = reg.matcher(fileName.toLowerCase());
                            if (!matcher.find()) {
                                state = "文件类型不允许！";
                                break;
                            }
                            String filename = new Date().getTime()
                                    + fileName.substring(
                                    fileName.lastIndexOf("."),
                                    fileName.length());
                            url = realPath + filename;

                            BufferedInputStream in = new BufferedInputStream(
                                    fis.openStream());// 获得文件输入流
                            FileOutputStream a = new FileOutputStream(new File(
                                    url));
                            BufferedOutputStream output = new BufferedOutputStream(
                                    a);
                            Streams.copy(in, output, true);// 开始把文件写到你指定的上传文件夹

                            //图片压缩
                            String compressImgName = "compress_" + filename;
                            CompressPhotoFile mypic = new CompressPhotoFile();
                            mypic.compressPic(realPath, realPath, filename, compressImgName, 320, 320, true);
                            imgUrl += compressImgName;
                        } else {
                            String fname = fis.getFieldName();

                            if (fname.indexOf("pictitle") != -1) {
                                BufferedInputStream in = new BufferedInputStream(
                                        fis.openStream());
                                byte c[] = new byte[10];
                                int n = 0;
                                while ((n = in.read(c)) != -1) {
                                    title = new String(c, 0, n);
                                    break;
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                title = title.replace("&", "&amp;").replace("'", "&qpos;")
                        .replace("\"", "&quot;").replace("<", "&lt;")
                        .replace(">", "&gt;");
                logger.info("add new img:" + imgUrl);
                //判断请求格式


                response.getWriter().print(
                        "{'url':'" + imgUrl + "','title':'" + title
                                + "','state':'" + state + "'}");


            } catch (FileUploadException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Method[] methods = this.getAllDeclaredMethods(this.getClass());
        boolean ALLOW_GET = false;
        boolean ALLOW_HEAD = false;
        boolean ALLOW_POST = false;
        boolean ALLOW_PUT = false;
        boolean ALLOW_DELETE = false;
        boolean ALLOW_TRACE = true;
        boolean ALLOW_OPTIONS = true;

        for (int allow = 0; allow < methods.length; ++allow) {
            Method m = methods[allow];
            if (m.getName().equals("doGet")) {
                ALLOW_GET = true;
                ALLOW_HEAD = true;
            }

            if (m.getName().equals("doPost")) {
                ALLOW_POST = true;
            }

            if (m.getName().equals("doPut")) {
                ALLOW_PUT = true;
            }

            if (m.getName().equals("doDelete")) {
                ALLOW_DELETE = true;
            }
        }

        String var13 = null;
        if (ALLOW_GET) {
            var13 = "GET";
        }

        if (ALLOW_HEAD) {
            if (var13 == null) {
                var13 = "HEAD";
            } else {
                var13 = var13 + ", HEAD";
            }
        }

        if (ALLOW_POST) {
            if (var13 == null) {
                var13 = "POST";
            } else {
                var13 = var13 + ", POST";
            }
        }

        if (ALLOW_PUT) {
            if (var13 == null) {
                var13 = "PUT";
            } else {
                var13 = var13 + ", PUT";
            }
        }

        if (ALLOW_DELETE) {
            if (var13 == null) {
                var13 = "DELETE";
            } else {
                var13 = var13 + ", DELETE";
            }
        }

        if (ALLOW_TRACE) {
            if (var13 == null) {
                var13 = "TRACE";
            } else {
                var13 = var13 + ", TRACE";
            }
        }

        if (ALLOW_OPTIONS) {
            if (var13 == null) {
                var13 = "OPTIONS";
            } else {
                var13 = var13 + ", OPTIONS";
            }
        }

        resp.setHeader("Allow", var13);
        resp.setHeader("Access-Control-Allow-Origin", "*");
    }

    private Method[] getAllDeclaredMethods(Class<?> c) {
        if (c.equals(HttpServlet.class)) {
            return null;
        } else {
            Method[] parentMethods = this.getAllDeclaredMethods(c.getSuperclass());
            Method[] thisMethods = c.getDeclaredMethods();
            if (parentMethods != null && parentMethods.length > 0) {
                Method[] allMethods = new Method[parentMethods.length + thisMethods.length];
                System.arraycopy(parentMethods, 0, allMethods, 0, parentMethods.length);
                System.arraycopy(thisMethods, 0, allMethods, parentMethods.length, thisMethods.length);
                thisMethods = allMethods;
            }

            return thisMethods;
        }
    }

}
