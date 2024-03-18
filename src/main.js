import '@babel/polyfill'
import 'mutationobserver-shim'
import './plugins/bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle'
import 'bootstrap-vue/dist/bootstrap-vue.css'; // Import BootstrapVue CSS
import { BootstrapVue } from 'bootstrap-vue'; // Import BootstrapVue
import { configureCompat } from '@vue/compat';
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// Configure Vue 3 to use Vue 2-compatible behavior
configureCompat({
  MODE: 3, // Set to 3 for Vue 2 behavior
  // Enable/disable specific features if needed
  // FEATURE_ID_A: true,
  // FEATURE_ID_B: true,
});

createApp(App).use(router, BootstrapVue).mount('#app')