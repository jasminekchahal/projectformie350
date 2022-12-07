<template>
    <div class="admin">
        <h2>Admin</h2>
        <button id = "tab3"><b-nav-item to="/tables" exact exact-active-class="exact-active">Tables</b-nav-item></button>
        <button id = "tab2"><b-nav-item to="/servers" exact exact-active-class="exact-active">Servers</b-nav-item></button>
        <button id = "tab1"><b-nav-item to="/reservations" exact exact-active-class="exact-active">Reservations</b-nav-item></button>
        <br>
            <!-- pretty picture :) -->
    <img src="https://i.pinimg.com/736x/52/bd/70/52bd70cfc5509ee16b2bb3dd11695c0a.jpg">
        <br>
        <br>
        <br>
        <br>
        <b-navbar-brand to="/reservations"><b-icon icon="book" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
        <br><d to="/reservations">Reservations Menu</d><br>
        <br>
        <br>
        <b-navbar-brand to="/servers"><b-icon icon="person" variant="warning" style="font-size: 3em; margin-left: 12px;"></b-icon></b-navbar-brand>
        <br><d to="/reservations">Servers Menu</d><br>
        <br>
        <br>
        <b-navbar-brand to="/tables"><b-icon icon="table" variant="warning" style="font-size: 3em; margin-left: 12px;"></b-icon></b-navbar-brand>
        <br><d to="/reservations"> Tables Menu</d><br>

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