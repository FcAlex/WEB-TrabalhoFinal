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
  }
}
</script>
