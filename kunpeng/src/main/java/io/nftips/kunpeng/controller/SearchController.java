package io.nftips.kunpeng.controller;

import cn.hutool.json.JSONUtil;
import io.nftips.kunpeng.common.Constants;
import io.nftips.kunpeng.service.NFTBlockChainInfoService;
import io.nftips.kunpeng.util.CommonUtil;
import io.nftips.kunpeng.util.R;
import io.nftips.kunpeng.vo.NFTInfoSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

import static io.nftips.kunpeng.common.MappingPath.CATEGORY_ID_SEARCH_V1;
import static io.nftips.kunpeng.common.MappingPath.CATEGORY_LIST_SEARCH_V1;
import static io.nftips.kunpeng.util.CodeEnum.NOT_FOUND_NFT;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/21 上午9:55
 **/
@RestController
public class SearchController {

    @Autowired
    private HttpServletResponse response;

    @Resource
    private NFTBlockChainInfoService nftBlockChainInfoService;

    @RequestMapping(value = {CATEGORY_ID_SEARCH_V1})
    @ResponseBody
    public void searchByCategoryId(@RequestParam(value = Constants.CATEGORY_ID) String categoryId ) {
        NFTInfoSearchVo vo = nftBlockChainInfoService.searchByCategory(categoryId);

        R r = R.ok(vo);
        if (vo ==null) {
            r = R.error(NOT_FOUND_NFT.getCode(), NOT_FOUND_NFT.getDesc());
        }
        String result = JSONUtil.toJsonStr(r);
        CommonUtil.printResult(response, result);
    }

    @RequestMapping(value = {CATEGORY_LIST_SEARCH_V1})
    @ResponseBody
    public void fuzzyQueryBaseInfo(@RequestParam(value = Constants.NAME) String name) {
        Map<String, Object> res = nftBlockChainInfoService.fuzzySearch(name);
        Map<String, Object> map = new HashMap<>(2);
        map.put("data", res);
        R r = R.ok(map);
        String result = JSONUtil.toJsonStr(r);
        CommonUtil.printResult(response, result);
    }
}
