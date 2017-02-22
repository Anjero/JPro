package net.anjero.pro.module.template.service;

import net.anjero.pro.module.template.mapper.TemplateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Anjero on 16/9/20.
 */

@Service
public class TemplateService {


    @Resource
    private TemplateMapper templateMapper;
}
