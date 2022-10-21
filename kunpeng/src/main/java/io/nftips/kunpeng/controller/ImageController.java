package io.nftips.kunpeng.controller;

import io.nftips.kunpeng.common.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static io.nftips.kunpeng.common.MappingPath.IMAGE_SEARCH_V1;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/21 上午9:34
 **/
@RestController
public class ImageController {

    @RequestMapping(value = {IMAGE_SEARCH_V1})
    @ResponseBody
    public void imageSearch(@RequestParam(value = Constants.IMAGE) MultipartFile imageData) {

    }
}
