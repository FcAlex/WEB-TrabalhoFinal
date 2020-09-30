<template>
  <div class="carousel-item" :class="first ? active : ''">
    <img :src="require(`../assets/carousel/${imagePath}`)" :alt="imageAlt" width="100%" />
    <div class="carousel-caption">
      <h3>{{title}}</h3>
      <p>{{text}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "CarouselItem",
  
  props: {
    title: "",
    imagePath: "",
    imageAlt: "",
    text: "",
    first: false
  },
  data() {
      return {
        active: "active",
      }
  }
};
</script>

<style>
</style>