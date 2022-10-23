<template>
<el-upload
    class="upload-demo"
    drag
    action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
    multiple
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

</script>

<style lang="scss" scoped>
.upload-demo{
    :deep(.el-upload-dragger){
        background-color:unset;
        border:unset;
        height: 48vh;
    }
}
</style>>
