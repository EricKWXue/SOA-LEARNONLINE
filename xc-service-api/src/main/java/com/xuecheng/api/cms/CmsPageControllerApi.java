package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;

public interface CmsPageControllerApi {
    /**
     * 查询网站页面列表
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);


    /**
     * 添加网站页面
     * @param cmsPage
     * @return
     */
    CmsPageResult addPage(CmsPage cmsPage);

    /**
     * 根据id查找页面
     * @param id
     * @return
     */
    CmsPage findById(String id);

    /**
     * 编辑页面
     * @param id
     * @param cmsPage
     * @return
     */
    public CmsPageResult editPage(String id, CmsPage cmsPage);


    /**
     * 删除页面
     * @param id
     * @return
     */
    public ResponseResult deletePage(String id);

    /**
     * 发布页面
     * @param id
     * @return
     */
    public ResponseResult postPage(String id);
}
