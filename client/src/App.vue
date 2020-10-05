<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  created: function() {
    var user = JSON.parse(localStorage.getItem("user"));
    if(user) {
      this.$http.get(this.baseURI + "/" + user).then((result) => {
        this.data = result.data;
      });
    }    
  }
}
</script>

<style>
</style>
