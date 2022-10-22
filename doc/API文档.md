## 1. 上传图片检索

URL: `query/image/v1`

Method: `POST`

Param:

| field | type | required |desc |
|:-----:|:----:|:--------:|-------|
| image | file | Y ||

Result:

``` json
{
    "msg": "success",
    "code": 0,
    "data": {
        "baseInfo": {
            "issueStep": "mint_nft",            // 发行阶段
            "occurTime": "2022-08-16T12:16:53", // 发行时间
            "categoryName": "心流",              // NFT类别名称
            "issueCount": 0,                    // 发行数量
            "sender": "",                       // 发行者
            "chainLink": "https://image.flow.xinliuspace.com/unsafe/20220816/9d0d5984d7d942f693beb11d9935b702", // 图片地址
            "realTradeCount": 505,              // 实际交易数量
            "categoryId": "avataluua5xn3gyvjvjpnw9tqwgcixiv", // 类别标识
            "holdingHuman": 63                  // 持有人数
        },
        "holdingPeriod": {                      // 持有周期
            "lager": {
                "radio": "0%",                  // 大于90d的占比
                "tip": "<90d"                  // 描述信息
            },
            "small": {
                "radio": "0%",                   // 大于七天之内
                "tip": "<7d"                     //  描述信息
            },
            "middle": {
                "radio": "0%",
                "tip": "<28d"
            }
        },
        "tradeSummary": {                       // 交易摘要
            "avgValue": 0,                      // 评价值
            "totalProfit": 0,                   // 累积交易额
            "lastTransferTime": "",             // 最近一次交易时间
            "lastTransferValue": 4800,          // 最近一次交易额
            "preTransferValueDiff": 2300,        // 与前一次的交易额差值
            "categoryId": "avataluua5xn3gyvjvjpnw9tqwgcixiv", // 分类ID
          	"transanctions": 235,                // 交易次数
            "accounts": 123,                     // 参与交易的账户数
          	"buyingIndex": 70                    // 投资指数
        }
    }
}
```

## 2. 通过NFT标识查询

URL: `query/categoryid/v1`

Method: `GET`

Param:

| field | type | required |desc |
|:-----:|:----:|:--------:|-------|
| category_id | String | Y ||

Result:

``` json
{
    "msg": "success",
    "code": 0,
    "data": {
        "baseInfo": {
            "issueStep": "mint_nft",            // 发行阶段
            "occurTime": "2022-08-16T12:16:53", // 发行时间
            "categoryName": "心流",              // NFT类别名称
            "issueCount": 0,                    // 发行数量
            "sender": "",                       // 发行者
            "chainLink": "https://image.flow.xinliuspace.com/unsafe/20220816/9d0d5984d7d942f693beb11d9935b702", // 图片地址
            "realTradeCount": 505,              // 实际交易数量
            "categoryId": "avataluua5xn3gyvjvjpnw9tqwgcixiv", // 类别标识
            "holdingHuman": 63                  // 持有人数
        },
        "holdingPeriod": {                      // 持有周期
            "lager": {
                "radio": "0%",                  // 大于90d的占比
                "tip": "<90d"                  // 描述信息
            },
            "small": {
                "radio": "0%",                   // 大于七天之内
                "tip": "<7d"                     //  描述信息
            },
            "middle": {
                "radio": "0%",
                "tip": "<28d"
            }
        },
        "tradeSummary": {                       // 交易摘要
            "avgValue": 0,                      // 评价值
            "totalProfit": 0,                   // 累积交易额
            "lastTransferTime": "",             // 最近一次交易时间
            "lastTransferValue": 4800,          // 最近一次交易额
            "preTransferValueDiff": 2300,        // 与前一次的交易额差值
            "categoryId": "avataluua5xn3gyvjvjpnw9tqwgcixiv", // 分类ID
          	"transanctions": 235,                // 交易次数
            "accounts": 123,                      // 参与交易的账户数
            "buyingIndex": 70                    // 投资指数
        }
    }
}
```

## 3. 通过NFT名称模糊搜索NFT类别列表
URL: `query/category/list/v1`

Method: `GET`

Param:

| field | type | required |desc |
|:-----:|:----:|:--------:|-------|
| name | String | Y ||

Result:

``` json
{
    "msg": "success",
    "code": 0,
    "data": {
      	list:[
          {
            "categoryId": "uewoewppoxpzx",
            "categoryName": "流心"
          },
          {
            "categoryId": "uewoewppoxpzx",
            "categoryName": "流心与明月"
          },
          {
            "categoryId": "uewoewppoxpzx",
            "categoryName": "流心月饼-端午纪念日"
          }
        ],
      	"count":1883
    }
}
```

## 4. 查询TOP10投资指数

URL: `query/top10/v1`

Method: `GET`

Param:

| field | type | required |desc |
|:-----:|:----:|:--------:|-------|
|       |      |          ||

Result:

``` json
{
    "msg": "success",
    "code": 0,
    "data": [
        {
            "gmtCreate": "2022-10-22T06:33:46", 
            "gmtModify": "2022-10-22T06:33:46",
            "categoryId": "avatabm8sjegcnpl8er9cs7v0osnrpee",       // 分类标识
            "categoryName": "Default",                              // 分类名称
            "sender": "iaa1pck9alvjxdm0rsfl99ku3dka3ddykkx7cu78q7", // 发行方
            "issueEnergyValue": 6810200000,                         // 上链消耗能量值，单位ugas
            "worth": 3665.70083,                                    // 累积交易额
          	"buyingIndex": 70                                       // 购买指数
        },
        {
            "gmtCreate": "2022-10-22T13:56:02",
            "gmtModify": "2022-10-22T13:56:02",
            "categoryId": "avataii0avb3d9ddy7idiv9iwnsfz4ik",
            "categoryName": "千里马-将军",
            "sender": "",
            "issueEnergyValue": 446000000,
            "worth": 414.00188
        },
        {
            "gmtCreate": "2022-10-22T01:08:04",
            "gmtModify": "2022-10-22T01:52:29",
            "categoryId": "avatanvhexx1llnb5hyu4vvl7mwjxbzx",
            "categoryName": "挽月数藏",
            "sender": "iaa1frcty3mmw09hcl0y46j62tstf885m77ma7kc60",
            "issueEnergyValue": 198000000,
            "worth": 231.01013
        },
        {
            "gmtCreate": "2022-10-22T00:50:00",
            "gmtModify": "2022-10-22T00:50:00",
            "categoryId": "avata3lalffjgjhmr451vwgfedomdqgd",
            "categoryName": "古镇-黄姚",
            "sender": "",
            "issueEnergyValue": 107000000,
            "worth": 160.50486
        },
        {
            "gmtCreate": "2022-10-22T00:57:42",
            "gmtModify": "2022-10-22T00:57:42",
            "categoryId": "yijingmeta",
            "categoryName": "艺境Meta",
            "sender": "iaa1u22uz6unxcrva3ly64r6jcdugz6hrssp8wmn58",
            "issueEnergyValue": 2818000000,
            "worth": 105.61477
        },
        {
            "gmtCreate": "2022-10-22T01:34:45",
            "gmtModify": "2022-10-22T01:34:45",
            "categoryId": "avatav6skngyjw3gupkfmqruvvsmpjly",
            "categoryName": "曙光系列",
            "sender": "",
            "issueEnergyValue": 61000000,
            "worth": 91.50852
        },
        {
            "gmtCreate": "2022-10-22T00:56:46",
            "gmtModify": "2022-10-22T01:13:58",
            "categoryId": "avataskdfav2puo38rxj1erjn7uurqwe",
            "categoryName": "数字藏品1mT",
            "sender": "iaa1rp6fm3d9u0x2uvh3639uc5anah7f9cyesxzzzq",
            "issueEnergyValue": 788000000,
            "worth": 85.21831
        },
        {
            "gmtCreate": "2022-10-22T09:38:46",
            "gmtModify": "2022-10-22T09:38:46",
            "categoryId": "avatafez6axhmgvxbjvdyxki6alsj2vq",
            "categoryName": "ugyishu_nft",
            "sender": "iaa162cfph5gs4f80jheg3jfjjwvafl4na9u6m42hs",
            "issueEnergyValue": 648400000,
            "worth": 84.30925
        },
        {
            "gmtCreate": "2022-10-22T01:35:25",
            "gmtModify": "2022-10-22T03:30:52",
            "categoryId": "avatae9d5uzfc1wcgrvogfw2g8qls51w",
            "categoryName": "银河文创",
            "sender": "iaa15zdcj5ur45gkntv5vhlxpe9vw44xcjymwhkm5l",
            "issueEnergyValue": 949400000,
            "worth": 79.51962
        },
        {
            "gmtCreate": "2022-10-22T00:55:26",
            "gmtModify": "2022-10-22T01:10:13",
            "categoryId": "syvdmf4zflpdmf0wicqqidhxhvikyukg",
            "categoryName": "新建类别",
            "sender": "iaa1jdvldxrhm34hv4md36zwhge28jd595uu307lms",
            "issueEnergyValue": 127400000,
            "worth": 64.21215
        }
    ]
}
```

## 5. NFT数据分析列表

URL: `query/data/analy/v1`

Method: `GET`

Param:

|   field    |  type  | required | desc |
| :--------: | :----: | :------: | ---- |
|    day     |  Int   |    Y     |      |
| categoryId | String |    Y     |      |

Result:

```json
{
  "msg": "success",
  "code": 0,
  "data": {
  	// 总转手天数
    "totalChangeDay": 2,
    //平均收益
    "averageRevenue": [
      {
      	// 收益
        "revenue": 10,
        //天数
        "time": 2022-10-22T00:55:26
      },
      {
        "revenue": 10,
        "time": 2022-10-22T00:55:26
      }
    ],
    //总涨幅
    "totalGains": 4000,
    //交易次数
    "tradingNumber": [
      {
      	// 次数
        "tradingNum": 10,
        //时间
        "time": 2022-10-22T00:55:26
      },
      {
        "tradingNum": 20,
        "time": 2022-10-22T00:55:26
      }
    ],
    //对比之前交易次数
    "beforeTradingNum": "+10",
    //对比之前收益
    "beforeRevenue": "-10.0",
    //总交易次数
    "totalTradingNum": 30,
    //对比之前转手天数
    "beforeChangeDay": "-0.5",
    //对比之前涨幅
    "beforeGains": "+1000",
    //总收益
    "totalRevenue": 20,
    // nft类别标识
    "categoryId": "2qasd2a1213asdz",
    //历史价格
    "priceHistory": [
      {
      	// 价格
        "price": 20,
        //时间
        "time": 2022-10-22T00:55:26
      },
      {
        "price": 40,
        "time": 2022-10-22T00:55:26
      }
    ]
  }
}
```

