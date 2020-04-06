import Vue from 'vue'
import Router from 'vue-router'
import Test from '@/components/Test'
import Employee from '@/components/employee/Employee'
import Customer from '@/components/customer/Customer'
import Car from '@/components/car/Car'
import Insurance from '@/components/insurance/Insurance'
import TestDrive from '@/components/testdrive/TestDrive'
import Transaction from '@/components/transaction/Transaction'
import Warehouse from '@/components/warehouse/Warehouse'
import Repair from '@/components/repair/Repair'
import Producer from '@/components/car/Producer'
import Brand from '@/components/car/Brand'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
Vue.use(Router)

export default new Router({
  // mode: 'history',
  routes: [
    {
      path: '',
      name: 'Login',
      component: Login
    },
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/repair',
      name: 'Repair',
      component: Repair
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    },
    {
      path: '/brand',
      name: 'Brand',
      component: Brand
    },
    {
      path: '/producer',
      name: 'Producer',
      component: Producer
    },
    {
      path: '/employee',
      name: 'Employee',
      component: Employee
    },
    {
      path: '/customer',
      name: 'Customer',
      component: Customer
    },
    {
      path: '/car',
      name: 'Car',
      component: Car
    },
    {
      path: '/insurance',
      name: 'Insurance',
      component: Insurance
    },
    {
      path: '/testdrive',
      name: 'Test Drive',
      component: TestDrive
    },
    {
      path: '/warehouse',
      name: 'Warehouse',
      component: Warehouse
    },
    {
      path: '/transaction',
      name: 'Transaction',
      component: Transaction
    }
  ]
})
