<template>
    <b-navbar toggleable="md" type="dark" variant="info">
  <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
  <b-navbar-brand to="/">JHKD</b-navbar-brand>

  <b-collapse is-nav id="nav_collapse">

    <b-navbar-nav>
      <b-nav-item to="/employee">Employess</b-nav-item>
      <b-nav-item to="/customer" >Customers</b-nav-item>
      <b-nav-item to="/car" >Cars</b-nav-item>
      <b-nav-item to="/transaction" >Transactions</b-nav-item>
      <b-nav-item to="/testdrive" >Test Drives</b-nav-item>
      <b-nav-item to="/insurance" >Insurances</b-nav-item>
      <b-nav-item to="/repair" >Repair</b-nav-item>
      <b-nav-item to="/brand" >Brands</b-nav-item>
      <b-nav-item to="/producer" >Producers</b-nav-item>
      <b-nav-item to="/warehouse" >Warehouses</b-nav-item>
      <!-- <b-nav-item href="/repair" >Repair</b-nav-item> -->
      
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

