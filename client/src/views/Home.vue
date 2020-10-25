<template>
  <div class="home">
    <Header></Header>
    <Carousel></Carousel>
    <Aside></Aside>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import Carousel from '@/components/Carousel.vue'
import Aside from '@/components/Aside.vue'

export default {
  name: 'Home',
  components: {
    Header,
    Footer,
    Carousel,
    Aside
  },
  data() {
    return {
      data: '',
      baseURI: "http://localhost:8080/api/users",
    };
  },
  created: function() {
    if(this.$session.exists()) {
      var user = JSON.parse(this.$session.get("user"));
      this.$http.get(this.baseURI + "/" + user.id).then((result) => {
        this.data = result.data;
      });
    }    
  }
}
</script>