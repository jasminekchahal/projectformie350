


<template>
  <div class="serverPage">
    <h2>Servers Page</h2>
    <button id = "tab1"><b-nav-item to="/addServer" exact exact-active-class="exact-active">New</b-nav-item></button>
    <button id = "tab2"><b-nav-item to="/servers" exact exact-active-class="exact-active">Current</b-nav-item></button>
    <button id = "tab3"><b-nav-item to="/serverReview" exact exact-active-class="exact-active">Review</b-nav-item></button>
    <br>

                <!-- pretty picture :) -->
  <img src="https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/d5c03a99139723.5eebce6281e84.jpeg">
      <br>
      <br>
      <br>
      <br>
      <b-navbar-brand to="/servers"><b-icon icon="person" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
      <br><d to="/servers">Current Servers</d><br>
      <br>
      <br>
      <b-navbar-brand to="/addServer"><b-icon icon="person-plus" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
      <br><d to="/addServer">New Servers</d><br>
      <br>
      <br>
      <b-navbar-brand to="/serverReview"><b-icon icon="pencil-square" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
      <br><d to="/serverReview">Review Servers</d><br>
      <br>
      <br>

</div>
</template>

<style scoped>
h1, h2 {
font-weight: light;
}
button {
font-size: 0.90em;
font-style: bold
}
img {
float: left;
}
ul {
list-style-type: none;
padding: 0;
}
img {
height: 350px;
width: 700px;
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
