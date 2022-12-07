<template>
  <div class="signup">
      <h2>Sign Up & Reserve a Table</h2>

<!--Edit form-->

<b-form>
  
  <label class="sr-only" for="input-name">Customer Name</label>
    <b-form-input
      id='input-name'
      v-model="form.name"
      placeholder="Customer Name"
      required
    ></b-form-input>

  <label class="sr-only" for="input-email">Customer Email</label>
    <b-form-input
        id='input-email'
        v-model="form.email"
        placeholder="Customer Email"
        required
    ></b-form-input>

  <label class="sr-only" for="input-number">Customer Phone Number</label>
    <b-form-input
        id='input-number'
        v-model="form.number"
        placeholder="Customer Phone Number"
        required
    ></b-form-input>

    <label class="sr-only" for="table_size">Table Size</label>
    <b-form-input
        id='table_size'
        v-model="form.guest_size"
        placeholder="Table Size"
        required
    ></b-form-input>

    <label class="sr-only" for="res-date">Date</label>
    <b-form-input
        id='res-date'
        v-model="form.date_time"
        placeholder="Date"
        required
    ></b-form-input>
    
    <br />
    <b-button type="button" v-b-modal.edit-modal @click="onSave" variant="primary">Reserve</b-button>
    
  </b-form>
  <b-modal id="edit-modal" title="Edit Table">
  
      <h2>Your Reservation ID is {{getResID(event)}} </h2>
    
    
  </b-modal>
</div>
</template>

<!--Creating backend methods-->
<script>
import axios from 'axios';

export default {
name: 'Customers',
data() {
    return {
        customers: null,
        fields: [
            {key: 'name', label: 'Customer Name'},
            {key: 'email', label: 'Customer Email'},
            {key: 'number', label: 'Customer Phone Number'},
        ],
        activeRes: null,
        activefields: [
            {key: 'phone_number', label: 'Customer Number'},
            {key: 'guest_size', label: 'Guest Size'},
            {key: 'date_time', label: 'Reservation Time'},
        ],

        form:{
            name: '',
            email: '',
            number: '',
            guest_size: '',
            date_time: '',
        },
    }
},

mounted (){
    this.init();
},

methods: {
    init() {
        axios
          .get('http://localhost:8085/customers')
          .then(response => (this.customers = response.data))
    },

    onSave(event) {
    axios
      .post('http://localhost:8085/customers',{
        "name": this.form.name,
        "email": this.form.email,
        "number": this.form.number
      })
      .then(() => this.saveRes(events))
      .catch(function (error) {
        console.log(error);
      });
    
    },

    saveRes(event) {
    axios
      .post('http://localhost:8085/Reservations',{
        "phone_number": this.form.number,
        "guest_size": this.form.guest_size,
        "date_time": this.form.date_time
      })
      .then(() => this.init())
      .catch(function (error) {
        console.log(error);
      });
    },

    getResID(event) {
      var resID;
      resID = "RES" + this.form.name.slice(-2) + this.form.number.slice(-4)
      return resID
    }

}
}
</script>

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