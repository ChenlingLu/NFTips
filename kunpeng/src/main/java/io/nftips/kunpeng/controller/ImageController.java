package io.nftips.kunpeng.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import io.nftips.kunpeng.common.Constants;
import io.nftips.kunpeng.service.NFTBlockChainInfoService;
import io.nftips.kunpeng.util.CommonUtil;
import io.nftips.kunpeng.util.PHash;
import io.nftips.kunpeng.util.R;
import io.nftips.kunpeng.vo.NFTInfoSearchVo;
import io.nftips.kunpeng.vo.NftInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

import static io.nftips.kunpeng.common.MappingPath.IMAGE_SEARCH_V1;
import static io.nftips.kunpeng.util.CodeEnum.*;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/21 上午9:34
 **/
@RestController
public class ImageController {
    @Autowired
    private HttpServletResponse response;

    @Resource
    private NFTBlockChainInfoService nftBlockChainInfoService;

    @RequestMapping(value = {IMAGE_SEARCH_V1})
    @ResponseBody
    public void imageSearch(@RequestParam(value = Constants.IMAGE) MultipartFile imageData) {
        if (imageData == null) {
            R r = R.error(IMAGE_NOT_ALLOW_EMPTY.getCode(), IMAGE_NOT_ALLOW_EMPTY.getDesc());
            String result = JSONUtil.toJsonStr(r);
            CommonUtil.printResult(response, result);
            return;
        }

        try (InputStream inputStream = imageData.getInputStream()) {
            String hash = PHash.getFeatureValue(inputStream);
            if (StrUtil.isBlank(hash)) {
                R r = R.error(IMAGE_FEATURE_FAIL.getCode(), IMAGE_FEATURE_FAIL.getDesc());
                String result = JSONUtil.toJsonStr(r);
                CommonUtil.printResult(response, result);
            }
            NFTInfoSearchVo nftInfoVo = nftBlockChainInfoService.searchByImgHash(hash);
            R r = R.ok(nftInfoVo);
            String result = JSONUtil.toJsonStr(r);
            CommonUtil.printResult(response, result);
        } catch (IOException e) {
            e.printStackTrace();
            R r = R.error(IMAGE_SEARCH_FAIL.getCode(), IMAGE_SEARCH_FAIL.getDesc());
            String result = JSONUtil.toJsonStr(r);
            CommonUtil.printResult(response, result);
        }
    }
}
