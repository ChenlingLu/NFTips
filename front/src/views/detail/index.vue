<template>
  <section class="detail">
    <Header show-back />
    <div class="container">
      <div class="left">
        <article class="detail_art">
          <div class="top">
            <div class="top-left">
              <div class="title">NFT info</div>
              <div class="media">
                <div class="media-img">
                  <img :src="data.detail?.baseInfo?.chainLink" alt="">
                  <div class="info">Currently {{data.detail?.baseInfo?.holdingHuman || '--'}} people holding</div>
                </div>
                <div class="media-content">
                  <div class="usd_0">
                    <div class="usd_a">{{data.detail.tradeSummary.lastTransferValue}} USD</div>
                    <div class="usd_b">+{{data.detail.tradeSummary.preTransferValueDiff}} USD <b>than last transaction
                      </b></div>
                    <div class="usd_c">Last transaction:{{data.detail.baseInfo.occurTime}}</div>
                  </div>
                  <div class="NFT">
                    <div class="NFT-text">
                      <div> NFT Name :</div>
                      <div>
                        {{data.detail.baseInfo.categoryName}} <br />
                      </div>
                    </div>
                    <div class="NFT-text">
                      <div class="NFT-text-name">Publisher :</div>
                      <div class="NFT-text-value">{{data.detail.baseInfo.sender}}</div>
                    </div>
                    <div class="NFT-text">
                      <div>
                        Raw Cost :
                      </div>
                      <div>
                        {{data.detail.tradeSummary.lastTransferValue}} USD <br />
                      </div>
                    </div>
                    The number of issued : {{data.detail.baseInfo.issueCount}}
                  </div>
                </div>
              </div>
            </div>
            <div class="top-right">
              <article class="detail_trade">
                <div class="title">
                  <div>
                    Trade info
                  </div>
                  <div class="info">{{data.detail.tradeSummary.transanctions || '--'}} transactions / {{
                  data.detail.tradeSummary.accounts || '--' }} accounts</div>
                </div>
                <p class="trade">
                  Total ：{{data.detail.tradeSummary.totalProfit}}<br />
                  Average bid price ：{{data.detail.tradeSummary.avgValue}}<br />
                  Average ask price ：{{data.detail.tradeSummary.askPrice || 0}}<br />
                  Holding period ：{{data.detail.tradeSummary.transanctions || 0}}<br />
                </p>
              </article>
              <Three class="three" :data="data.detail.holdingPeriod" />
            </div>
          </div>
        </article>

        <div class="analytics">
          <div class="analytics-title">
            <div class="title">
              Analytics
            </div>
            <el-select v-model="selectValue.value" class="nft_select" placeholder="Select" @change="handleSelectChange">
              <el-option label="Past 28 days" value="28" />
              <el-option label="Past 7 days" value="7" />
              <el-option label="Yesterday" value="1" />
            </el-select>
          </div>

          <div class="analytics-content">
            <div class="level">
              <div class="title">-- USD</div>
              <div class="subtitle">Average revenue</div>
              <div class="secondary-title">+-- USD</div>
              <div class="time">than last month</div>
              <SimpleBar type="revenue" :data="analyData.data.averageRevenue" />
            </div>
            <div class="level">
              <div class="title">-- times</div>
              <div class="subtitle">Total transactions</div>
              <div class="secondary-title blue">--- times</div>
              <div class="time">than last month</div>
              <SimpleBar type="tradingNum" :data="analyData.data.tradingNumber" />
            </div>
            <div class="level">
              <div class="title">-- h</div>
              <div class="subtitle">Average re-sale time</div>
              <div class="secondary-title green">---h</div>
              <div class="time">than last month</div>
              <SimpleBar />
            </div>
            <div class="level">
              <div class="title">+--/---</div>
              <div class="subtitle">Highest increase / decrease</div>
              <div class="secondary-title orange">+-- USD</div>
              <div class="time">Average increase / decrease </div>
              <SimpleBar />
            </div>
          </div>
        </div>

        <div class="history">
          <div class="history-title">Price History</div>
          <div class="history-content">
            <LineSimple :data="analyData.data.priceHistory" />
          </div>
        </div>

        <!-- <Zhe /> -->
      </div>

      <div class="right">
        <HomeRight :echartData="data.detail.tradeSummary.buyingIndex" />
      </div>
    </div>




  </section>
</template>
 
<script setup>
import Header from "@/components/header.vue"
import { ElSelect } from 'element-plus'
import HomeRight from "@/components/homeRight.vue"
import SimpleBar from "@/components/SimpleBar.vue"
import LineSimple from "@/components/LineSimple.vue"

import { reactive, onMounted } from 'vue'
import Three from "@/components/three.vue"
import { useRoute } from "vue-router";
import service from '@/utils/request';


const selectValue = reactive({
  value: '28'
})
const analyData = reactive({
  data: {
    averageRevenue: []
  }
})

const data = reactive({
  id: '',
  detail: {
    baseInfo: {},
    tradeSummary: {},
    holdingPeriod: {}
  }
})
data.id = new useRoute().query.id;

service({
  url: 'query/categoryid/v1',
  params: {
    category_id: data.id
  },
  method: 'get',
}).then(res => {
  if (res.data) {
    data.detail = res.data;
  }
})

onMounted(() => {
  fetchAnalyData();
})

const fetchAnalyData = () => {
  service({
    url: 'query/data/analy/v1',
    params: {
      day: selectValue.value,
      category_id: data.id
    },
    method: 'get',
  }).then(res => {
    if (res.data) {
      analyData.data = res.data;
    }
  })
}

const handleSelectChange = (value) => {
  selectValue.value = value
  fetchAnalyData();
}


</script>

<style scoped lang="scss">
.detail {
  .top {
    display: flex;
  }

  .top-right {
    margin-left: 32px;
    margin-right: 20px;
    flex: 1;

    .title {
      font-weight: 700;
      font-size: 20px;
      line-height: 24px;
      color: #FFFFFF;
    }
  }

  .top-left {
    .title {
      padding-bottom: 20px;
      font-weight: 700;
      font-size: 20px;
      line-height: 24px;
      color: #FFFFFF;
    }

  }

  .media {
    display: flex;

    img {
      width: 188px;
      height: 250px;
      background: #FFFFFF;
      border-radius: 12px;
      border: 4px solid #fff;
    }

    .info {
      font-size: 12px;
      line-height: 15px;
      color: #E0E0E0;
      margin-top: 12px;
      padding-left: 10px;

      &::before {
        content: '';
        width: 6px;
        height: 6px;
        border-radius: 50%;
        display: inline-block;
        background-color: #04CCC0;
        line-height: 15px;
        margin-right: 6px;
        margin-top: -2px;
      }
    }

    .media-content {
      margin-left: 20px;
    }
  }

  .analytics {
    margin-top: 40px;

    .analytics-title {
      display: flex;
      gap: 14px;
      align-items: center;

      .title {
        font-weight: 700;
        font-size: 20px;
        line-height: 24px;
        color: #FFFFFF;
      }
    }

    .analytics-content {
      display: flex;
      gap: 32px;
    }

    .level {
      padding: 24px 0;
      max-width: 200px;
      flex: 1;

      .title {
        font-weight: 500;
        font-size: 24px;
        line-height: 29px;
        color: #FFFFFF;
      }

      .subtitle {
        font-weight: 400;
        font-size: 12px;
        line-height: 15px;
        color: #7C7C7C;
        margin-top: 6px;
      }

      .secondary-title {
        font-weight: 400;
        font-size: 12px;
        line-height: 15px;
        color: #FFF500;
        margin-top: 10px;

        &.blue {
          color: #0286FF;
        }

        &.green {
          color: #04CCC0;
        }

        &.orange {
          color: #FF8B4A;
        }
      }

      .time {
        font-weight: 400;
        font-size: 12px;
        line-height: 15px;
        color: #FFFFFF;
        margin-bottom: 8px;
      }
    }
  }

  .history {
    .history-title {
      font-weight: 700;
      font-size: 20px;
      line-height: 24px;
      color: #FFFFFF;
      margin-bottom: 18px;
    }

    &-content {
      border: 1px solid #282828;
      border-radius: 6px;
    }
  }

  .detail_trade {
    font-size: 20px;
    line-height: 24px;
    color: #FFFFFF;

    .title {
      display: flex;
      align-items: center;

      .info {
        font-size: 12px;
        line-height: 15px;
        color: #D9D9D9;
        margin-left: 10px;

        &::before {
          content: '';
          width: 6px;
          height: 6px;
          border-radius: 50%;
          display: inline-block;
          background-color: #04CCC0;
          line-height: 15px;
          margin-right: 6px;
          margin-top: -2px;
        }
      }
    }

    .trade {
      font-size: 16px;
      line-height: 19px;
      margin: 20px 0px;
      color: #E0E0E0;
    }
  }

  .detail_art {

    color: #FFFFFF;

    .NFT {
      font-size: 16px;
      color: #E0E0E0;
      line-height: 1.6;
      max-width: 300px;

      &-text {
        display: flex;

        &-name {
          width: 72px;
        }

        &-value {
          flex: 1;
          word-break: break-all;
        }
      }
    }

    .usd_0 {
      border: 0.01rem solid #474747;
      border-radius: 0.06rem;
      padding: 20px;
      width: 200px;
      margin-bottom: 16px;

      .usd_a {
        font-size: 24px;
        color: #04CCC0;
        padding-bottom: 10px;
      }

      .usd_b {
        font-size: 12px;
        color: #FFE600;
        padding-bottom: 10px;

        b {
          font-size: 12px;
          line-height: 15px;
          color: #7C7C7C;
        }
      }

      .usd_c {
        font-size: 12px;
        line-height: 15px;
        color: #7C7C7C;
      }
    }

    .title {
      font-size: 20px;
    }

  }



  .nft_select {
    .el-input__wrapper {
      background-color: #4e4e4e;
    }

    :deep(.el-input__wrapper) {
      box-shadow: 0 0 0 0.01rem #4E4E4E inset;
    }

    :deep(.el-select__popper.el-popper) {
      --el-bg-color-overlay: #272727;
    }

    :deep(.el-input) {
      --el-input-bg-color: #272727;
      --el-input-text-color: #fff;
    }


  }



  // :deep(.el-select__popper.el-popper) {
  //   --el-bg-color-overlay: #272727;
  // }
}
</style>