<template  slot-scope="data">
  <div class="hello">
    <h1>{{ msg }}</h1>
    <ul>
      <li>
        
      </li>
      <li>
       
      </li>
      <li>
       
      </li>
      <li>
        
      </li>
      <br>
      <li>
       
      </li>
    </ul>
    <h2>We provdide proffesional services <br> in the field of buying car:</h2>
    <ul>
      <li>
        
      </li>
      <li>
       <h6>Professional employees, <br> Repairs <br> Test Drives <br> And safe transactions </h6>
      </li>
      <li>
        
      </li>
      <li>
        
      </li>
    </ul>
    <span>
    <img src="assets/carr.svg"/>
    </span>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to JHKD Car Dealr Shop'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0px;
}
a {
  color: #42b983;
}
</style>
