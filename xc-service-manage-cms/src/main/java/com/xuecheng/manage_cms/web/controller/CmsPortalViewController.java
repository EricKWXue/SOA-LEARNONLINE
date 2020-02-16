package com.xuecheng.manage_cms.web.controller;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.manage_cms.service.PageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/cms/portal")
public class CmsPortalViewController{

    @Autowired
    PageService pageService;

    @GetMapping("/page/{id}")
    public void previewPageById(@PathVariable("id") String pageId, HttpServletResponse response) throws IOException {
        String pageHtml = pageService.findPageHtmlById(pageId);
        if(StringUtils.isNotEmpty(pageHtml)){
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(pageHtml.getBytes(StandardCharsets.UTF_8));
        }
    }

    @ResponseBody
    @GetMapping("/model/{id}")
    public CmsConfig findModelById(@PathVariable("id") String id){
        return pageService.findConfigById(id);
    }
}
