<template slot="act">
<div>
    <span>
    <b-img  src="../../assets/car.jpg" />
    </span>
  </div>
</template>

<script>
import axios from 'axios'
// import VueImageLoader from '@kevindesousa/vue-image-loader'
import { Image } from 'bootstrap-vue/es/components';
export default {
components:{
    axios
},
  data () {
    return {
     act:""
    }
  }
}
</script>