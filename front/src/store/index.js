import { createStore } from "vuex"

// 创建新的 store 实例
const store = createStore({
 state: {
  name:'前端人'
 },
 getters: { },
 mutations: {
    changeName(state,data) {
        //data 是传入要修改的值
       state.name = data
      }
  },
 actions: { },
 modules: { }
})

export default store