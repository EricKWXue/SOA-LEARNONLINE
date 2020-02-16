package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Test
    public void testFindPage(){
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    @Test
    public void testInsertPage(){
        //定义实体类
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);

        CmsPage page = cmsPageRepository.save(cmsPage);
        System.out.println(page);
        System.out.println(cmsPage);
    }

    @Test
    public void testDeletePage(){
        cmsPageRepository.deleteById("");
    }

    @Test
    public void testUpdatePage(){
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageId("5a754adf6abb500ad05688d9");
        Example<CmsPage> cmsPageExample = Example.of(cmsPage);
        Optional<CmsPage> optional = cmsPageRepository.findOne(cmsPageExample);
        optional.ifPresent(cmsPageResult -> {
            System.out.println(cmsPageResult);
        });
    }

    @Test
    public void testFindAll(){
        ExampleMatcher matching = ExampleMatcher.matching().withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //条件值
        CmsPage cmsPage = new CmsPage();
        //cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        cmsPage.setPageAliase("分类");
        //cmsPage.setTemplateId("5a962c16b00ffc514038fafd");

        Example<CmsPage> example = Example.of(cmsPage, matching);
        Pageable pageable= PageRequest.of(0, 10);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        all.forEach(System.out::println);
    }
}
