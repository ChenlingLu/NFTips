package io.nftips.kunpeng.controller;

import io.nftips.kunpeng.service.NFTClassificationTopService;
import io.nftips.kunpeng.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static io.nftips.kunpeng.common.MappingPath.TOP10_SEARCH_V1;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/21 上午9:55
 **/
@RestController
public class TopController {

    @Resource
    private NFTClassificationTopService nftClassificationTopService;

    @RequestMapping(value = {TOP10_SEARCH_V1})
    @ResponseBody
    public R worthTop10() {
        R r = nftClassificationTopService.top10();
        return r;
    }
}
