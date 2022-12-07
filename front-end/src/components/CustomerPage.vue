<!--Customer Page-->
<template>
    <div class="customerPage">
        <h2>Customer Page</h2>
        <button id = "tab1"><b-nav-item to="/reservationForm" exact exact-active-class="exact-active">Edit Reservation</b-nav-item></button>
        <button id = "tab2"><b-nav-item to="/signUpForm" exact exact-active-class="exact-active">Sign Up</b-nav-item></button>
        <button id = "tab3"><b-nav-item to="/meetTheTeam" exact exact-active-class="exact-active">Meet Us</b-nav-item></button>
            <!-- pretty picture :) -->
    <img src="https://i.pinimg.com/736x/af/93/3e/af933e60b17982f1077dbcffc9cf6e9b.jpg">
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <b-navbar-brand to="/signUpForm"><b-icon icon="book" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
        <br><d to="/signUpForm">Create Reservation</d><br>
        <br>
        <br>
        <b-navbar-brand to="/reservationForm"><b-icon icon="pencil-square" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
        <br><d to="/reservationForm">Edit Reservation</d><br>
        <br>
        <br>
        <!-- edit with new stuff from katriel for meet the team-->
        <b-navbar-brand to="/meetTheTeam"><b-icon icon="people" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
        <br><d to="/meetTheTeam">Meet the Team</d><br>
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