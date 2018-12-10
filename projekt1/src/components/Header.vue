<template>
    <b-navbar toggleable="md" type="dark" variant="info">
  <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
  <b-navbar-brand href="#">JHKD <br>Car Dealer Shop</b-navbar-brand>

  <b-collapse is-nav id="nav_collapse">

    <b-navbar-nav>
      <b-nav-item href="/employee">Employess</b-nav-item>
      <b-nav-item href="/customer" >Customers</b-nav-item>
      <b-nav-item href="/testdrive" >Test Drives</b-nav-item>
      <b-nav-item href="/insurance" >Insurances</b-nav-item>
      <b-nav-item href="/transaction" >Transactions</b-nav-item>
      <b-nav-item href="/car" >Cars</b-nav-item>
      <b-nav-item href="/warehouse" >Warehouses</b-nav-item>
      
    </b-navbar-nav>

    <!-- Right aligned nav items -->
    <b-navbar-nav class="ml-auto">

      <!-- <b-nav-form>
        <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Search"/>
        <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
      </b-nav-form> -->
    </b-navbar-nav>

  </b-collapse>
</b-navbar>

<!-- navbar-1.vue -->
</template>
<script>
export default {
    
}
</script>

