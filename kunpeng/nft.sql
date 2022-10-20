-- nft列表
CREATE TABLE `bsn_nft_list`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `ntf_type` varchar(128) COMMENT 'NFT标识',
    `ntf_name` varchar(128) COMMENT 'NFT名称',
    `catagory_id` varchar(128) COMMENT '类别标识',
    `catagory_name` varchar(128) COMMENT '类别名称',
    `owner` varchar(128) COMMENT '拥有者',
    `occur_time` timestamp COMMENT '发生时间',
    `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 藏品信息 需要根据列表中nft名称查询一次
CREATE TABLE `bsn_nft_info`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `nft_url` varchar(256) COMMENT '藏品图片',
    `nft_publisher` varchar(128) COMMENT '藏品发行者',
    `nft_num` bigint(20) COMMENT '藏品发行数量',
    `ntf_name` varchar(128) COMMENT '藏品名称',
    `catagory_id` varchar(128) COMMENT '类别标识',
    `catagory_name` varchar(128) COMMENT '类别名称',
    `occur_time` timestamp COMMENT '发生时间',
    `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- nft交易记录 根据nft标识查询
CREATE TABLE `bsn_nft_trading`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `ntf_type` varchar(128) COMMENT 'NFT标识',
    `trading_hash` varchar(256) COMMENT '交易hash',
    `trading_type` varchar(128) COMMENT '交易类型',
    `catagory_id` varchar(128) COMMENT '类别标识',
    `trading_sender` varchar(128) COMMENT '发送者',
    `height` varchar(64) COMMENT '区块高度',
    `energy_value` bigint(20) COMMENT '能量值',
    `occur_time` timestamp COMMENT '发生时间',
    `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- nft 交易记录详情 根据交易hash查询
CREATE TABLE `bsn_nft_trading_info`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `trading_hash` varchar(256) COMMENT '交易hash',
    `trading_status` int(1) COMMENT '交易状态 1成功 0失败'
    `height` varchar(64) COMMENT '区块高度',
    `energy_value` bigint(20) COMMENT '能量值',
    `remark` varchar(128) COMMENT '备注',
    `trading_type` varchar(128) COMMENT '交易类型',
    `catagory_id` varchar(128) COMMENT '类别标识',
    `catagory_name` varchar(128) COMMENT '类别名称',
    `ntf_type` varchar(128) COMMENT 'NFT标识',
    `ntf_name` varchar(128) COMMENT 'NFT名称',
    `sender` varchar(128) COMMENT '发送者',
    `recipient` varchar(128) COMMENT '接收者',
    `code` text COMMENT '源码',
    `occur_time` timestamp COMMENT '发生时间',
    `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
