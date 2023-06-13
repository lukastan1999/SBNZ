import { createRouter, createWebHistory } from 'vue-router'
import UserInput from '@/views/UserInput.vue'

const routes = [
  {
    path: '/',
    name: 'UserInput',
    component: UserInput,
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
