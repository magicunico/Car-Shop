import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Test from '@/components/Test'
import Employee from '@/components/employee/Employee'
import Customer from '@/components/customer/Customer'
import Car from '@/components/car/Car'
import Insurance from '@/components/insurance/Insurance'
import TestDrive from '@/components/testdrive/Testdrive'
import Transaction from '@/components/transaction/Transaction'
import Warehouse from '@/components/warehouse/Warehouse'
import Repair from '@/components/repair/Repair'


Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
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
