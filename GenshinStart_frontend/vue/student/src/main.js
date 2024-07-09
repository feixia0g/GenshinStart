// eslint-disable-next-line semi
import Vue from "vue";
// eslint-disable-next-line semi
import App from "./App.vue";

Vue.config.productionTip = false;

new Vue({
  // eslint-disable-next-line comma-dangle
  render: (h) => h(App),
  // eslint-disable-next-line semi
}).$mount("#app");
