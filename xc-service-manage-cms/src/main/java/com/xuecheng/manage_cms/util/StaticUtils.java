package com.xuecheng.manage_cms.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

public class StaticUtils {

    /**
     * 模板引擎
     */
    private static final TemplateEngine templateEngine = new TemplateEngine();

    /**
     * 生成html文件
     * @param templateContent
     * @param model
     * @return
     */
    public static String generateHtml(String templateContent, Map<String, Object> model){
        Context context = new Context();
        context.setVariables(model);
        return templateEngine.process(templateContent, context);
    }
}
