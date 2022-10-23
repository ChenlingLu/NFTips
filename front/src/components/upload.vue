<template>
<el-upload
    class="upload-demo"
    drag
    action="/query/image/v1"
    :on-change="handleUpload"
  >
    <el-icon class="el-icon--upload"><upload-filled /></el-icon>
    <div class="el-upload__text">
      Drop file here or <em>click to upload</em>
    </div>
  
  </el-upload>
</template>

<script setup name="upload">
import { UploadFilled } from '@element-plus/icons-vue'

import { ElUpload } from 'element-plus'

const handleUpload = (e) => {
  console.log(e);
}
</script>

<style lang="scss" scoped>
.upload-demo{
    :deep(.el-upload-dragger){
        background-color:unset;
        border:unset;
    }
}
</style>>
