package com.xuecheng.manage_cms.web.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    PageService pageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {
        return pageService.findPageList(page,size,queryPageRequest);
    }

    @Override
    @PostMapping("/add")
    public CmsPageResult addPage(@RequestBody CmsPage cmsPage) {
        return pageService.addPage(cmsPage);
    }

    @Override
    @GetMapping("/get/{id}")
    public CmsPage findById(@PathVariable("id") String id) {
        return pageService.findPageById(id);
    }

    @Override
    @PutMapping("/edit/{id}")
    public CmsPageResult editPage(@PathVariable("id") String id, @RequestBody CmsPage cmsPage) {
        return pageService.updatePage(id, cmsPage);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult deletePage(@PathVariable("id") String id) {
        return pageService.deletePage(id);
    }

    @Override
    @PostMapping("/post/{id}")
    public ResponseResult postPage(@PathVariable("id") String id) {
        return pageService.postPage(id);
    }
}
