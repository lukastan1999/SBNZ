import { createRouter, createWebHistory } from 'vue-router'
import UserInput from '@/views/UserInput.vue'
import OutputData from '@/views/OutputData.vue'

const routes = [
  {
    path: '/',
    name: 'UserInput',
    component: UserInput,
  },
  {
    path: '/output',
    name: 'OutputData',
    component: OutputData,
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
