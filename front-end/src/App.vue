<template>
  <div id = "app">
  <b-container>
    <div>
      <!-- top bar -->
      <!-- ... where is the book icon??? -->
      <b-navbar toggleable type="light" variant= #F5F2E9>
      <b-navbar-brand to="/"><b-icon icon="egg" variant="warning" style="margin-left: 20px;"></b-icon> Jo's Brunch Restaurant </b-navbar-brand>

      <!-- toggle side bar menu -->
      <b-navbar-toggle target="sidebar-menu">
      </b-navbar-toggle>

      <!-- this is the pop-up side bar -->
      <b-sidebar id="sidebar-menu" title="main menu" backdrop-variant="dark" backdrop shadow>
        <b-nav vertical align="center">

          <!-- need to change links to databases on index.js -->
          <!-- also need to change names! these go to the xxx.vue thingy -->
          <b-nav-item to="/" exact exact-active-class="exact-active">home</b-nav-item>
          <b-nav-item to="/customerPage" exact exact-active-class="exact-active">for customers</b-nav-item>
          <b-nav-item to="/adminPage" exact exact-active-class="exact-active">for admin</b-nav-item>
          <b-nav-item to="/serverPage" exact exact-active-class="exact-active">for servers</b-nav-item>
          <b-nav-item to="/meetTheTeam" exact exact-active-class="exact-active">meet the team</b-nav-item>


          <!-- why is this even here... just remove it lol -->
          <!--
            <b-nav-item disabled>Admin</b-nav-item>
          -->
        </b-nav>
      </b-sidebar>
    </b-navbar>
    </div>
    <br />
    <router-view/>
    </b-container>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<!--style only looks at the bg colour?? not the photos and stuff-->

<style>

@import './assets/test.css';

@import url(https://fonts.googleapis.com/css?family=Libre+Baskerville);
#app {
  font-family: 'Libre Baskerville';
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  /*not sure what colour this is pertaining to...*/
  /*NVM I FOUND IT!! ITS THE GLOBAL FONT I THINK*/
  /*anywya i wanna chanegt his to a light grey*/
  color: #222222;
  margin-top: 20px;
}

</style>
