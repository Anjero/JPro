package net.anjero.pro.module.system.service;

import net.anjero.common.constant.Globals;
import net.anjero.common.util.BrowserUtils;
import net.anjero.common.util.IpUtils;
import net.anjero.pro.module.system.mapper.SysLogMapper;
import net.anjero.pro.module.system.pojo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 日志记录类
 * Created by xionghui on 2016/3/23.
 */
@Service
public class SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;


    public int addLog(Integer userId, String broswer, String operateip, String content, String trackId, Integer loglevel, Integer operatetype, Date operatetime) {
        SysLog sysLog = new SysLog();
        sysLog.setUserid(userId);
        sysLog.setLogcontent(content);
        sysLog.setTrackId(trackId);
        sysLog.setLoglevel(loglevel);
        sysLog.setOperatetime(operatetime);
        sysLog.setOperatetype(operatetype);
        sysLog.setBroswer(broswer);
        sysLog.setOperateip(operateip);
        return sysLogMapper.insertSelective(sysLog);
    }


    public int addLoginLog(HttpServletRequest request, Integer userId, String content, String trackId) {
        SysLog sysLog = new SysLog();
        sysLog.setUserid(userId);
        sysLog.setLogcontent(content);
        sysLog.setTrackId(trackId);
        sysLog.setLoglevel(Globals.Log_Leavel_INFO);
        sysLog.setOperatetime(new Date());
        sysLog.setOperatetype(Globals.Log_Type_LOGIN);
        sysLog.setBroswer(BrowserUtils.checkBrowse(request));
        sysLog.setOperateip(IpUtils.getIpAddrByRequest(request));
        return sysLogMapper.insertSelective(sysLog);
    }
}
