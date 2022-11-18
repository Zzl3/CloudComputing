import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/views/Index'
import Thing from '@/views/Thing'
import User from '@/views/User'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: 'index'
    },
    {
      path: '/index',
      component: Index
    },
    {
      path: '/user',
      component: User
    },
    {
      path: '/thing',
      component: Thing
    },
  ]
})
