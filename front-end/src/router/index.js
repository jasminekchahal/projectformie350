import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import CustomerPage from '@/components/CustomerPage'
import AdminPage from '@/components/AdminPage'
import SignUpForm from '@/components/SignUpForm'
import ReservationForm from '@/components/ReservationForm'
import Reservations from '@/components/Reservations'
import Servers from '@/components/Servers'
import Tables from '@/components/Tables'
import ServerPage from '@/components/ServerPage'
import ServerReview from '@/components/ServerReview'
import AddServer from '@/components/AddServer'
import meetTheTeam from '@/components/meetTheTeam'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },

    {
      path: '/customerPage',
      name: 'CustomerPage',
      component: CustomerPage
    },

    {
      path: '/adminPage',
      name: 'AdminPage',
      component: AdminPage
    },

    {
      path: '/reservationForm',
      name: 'ReservationForm',
      component: ReservationForm
    },

    {
      path: '/signUpForm',
      name: 'SignUpForm',
      component: SignUpForm
    },

    {
      path: '/reservations',
      name: 'Reservations',
      component: Reservations
    },

    {
      path: '/servers',
      name: 'Servers',
      component: Servers
    },

    {
      path: '/tables',
      name: 'Tables',
      component: Tables
    },

    {
      path: '/serverPage',
      name: 'ServerPage',
      component: ServerPage
    },
    
    {
       path: '/addServer',
       name: 'addServer',
       component: AddServer
     },

    {
      path: '/serverReview',
      name: 'ServerReview',
      component: ServerReview
    },

    {
      path: '/meetTheTeam',
      name: 'meetTheTeam',
      component: meetTheTeam
    },
  ]
})
