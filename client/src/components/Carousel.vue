<template>
  <section id="demo" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
      <CarouselItem 
        title="Adote um novo amigo!"
        text="Ao se entregar ao ato de adotar, você estar amando e, com certeza, será amado"
        imagePath="cat_1.jpg"
        imageAlt="Eis um gato"
        first="true">
      </CarouselItem>

      <CarouselItem 
        title="Adote um novo amigo!"
        text="Ao se entregar ao ato de adotar, você estar amando e, com certeza, será amado"
        imagePath="dog_1.jpg"
        imageAlt="Eis um cachorro">
      </CarouselItem>

      <CarouselItem 
        title="Adote um novo amigo!"
        text="Ao se entregar ao ato de adotar, você estar amando e, com certeza, será amado"
        imagePath="dog_2.jpg"
        imageAlt="Eis um cachorro">
      </CarouselItem>
    </div>

    <a class="carousel-control-prev" href="#demo" data-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
      <span class="carousel-control-next-icon"></span>
    </a>
  </section>
</template>

<script>
import CarouselItem from './CarouselItem.vue';

export default {
    name: 'Carousel',
    components: {
      CarouselItem
    }
}
</script>

<style>
.carousel-caption {
  background-color: rgba(0, 0, 0, 0.3);
}
</style>