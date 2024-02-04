import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddCategory from '../views/Category/AddCategory'
import ListCategories from '../views/Category/ListCategory'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path:'/admin/Category/add',
    name:'AddCategory',
    component: AddCategory
  },
  {
    path: '/admin/Category',
    name: 'ListCategories',
    component: ListCategories
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router