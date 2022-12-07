<template>
  <div>
    <!-- header -->
    <h1 id="title" style= "text-align:left">Welcome to Jo's</h1>
    
    <!-- not clickable -->
    <div id = "buttons">

      <button id = "tab3"><b-nav-item to="/serverPage" exact exact-active-class="exact-active">for servers</b-nav-item></button>
      <button id = "tab2"><b-nav-item to="/adminPage" exact exact-active-class="exact-active">for admin</b-nav-item></button>
      <button id = "tab1"><b-nav-item to="/customerPage" exact exact-active-class="exact-active">for customers</b-nav-item></button>
    </div>

    <!-- pretty picture :) -->
    <img src="https://64.media.tumblr.com/36bef515de20356e25786c8c75cc72b7/0e098fba88c0fbdc-2f/s640x960/59526846ef244586e94277e2ee4eaa9ac8233440.jpg">

    <!-- the text to catch ppls eyeball -->
    <div id = "pages">
      <br><br><br><br><br>
      <b>
        <p id = "toChange">
          we make <br> affordable, <br> homemade, <br> & delicious <br>brunch
        </p>
      </b>
      <br><br><br><br><br>
    </div>

  </div>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: light;
}
button {
  font-size: 0.90em;
  font-style: bold
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
  /*idk what this corresponds to*/
  color: #222222;
}
</style>
