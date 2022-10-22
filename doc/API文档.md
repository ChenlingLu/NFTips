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
            "issueStep": "mint_nft",
            "occurTime": "2022-08-16T12:16:53",
            "categoryName": "心流",
            "issueCount": 0,
            "sender": "",
            "chainLink": "https://image.flow.xinliuspace.com/unsafe/20220816/9d0d5984d7d942f693beb11d9935b702",
            "realTradeCount": 505,
            "categoryId": "avataluua5xn3gyvjvjpnw9tqwgcixiv"
        },
        "holdingPeriod": {
            "lager": {
                "radio": "0%",
                "tip": "<365d"
            },
            "small": {
                "radio": "0%",
                "tip": "<365d"
            },
            "middle": {
                "radio": "0%",
                "tip": "<365d"
            }
        },
        "tradeSummary": {
            "avgValue": 0,
            "totalProfit": 0,
            "lastTransferTime": "",
            "lastTransferValue": 0,
            "categoryId": "avataluua5xn3gyvjvjpnw9tqwgcixiv"
        }
    }
}
```



