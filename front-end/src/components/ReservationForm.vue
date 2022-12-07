<template>
  <div class="reserve">
      <h2>Reserve</h2>
<b-form>
  
  <label class="sr-only" for="input-id">Reservation ID</label>
    <b-form-input
      id='input-id'
      v-model="form.reservation_id"
      placeholder="Reservation ID"
      required
    ></b-form-input>
    
    <br />
    <b-button type="button" v-b-modal.create-modal variant="primary">Update</b-button>
    <b-button type="button" @click="deleteRes" variant="danger">Cancel</b-button>

  </b-form>

<b-modal id="create-modal" title="Create Reservation" @hide="resetCreateModal" hide-footer>
<b-form>
  
  <label class="sr-only" for="input-number">Customer Phone Number</label>
    <b-form-input
        id='input-number'
        v-model="cform.phone_number"
        placeholder="Customer Phone Number"
        required
    ></b-form-input>

    <label class="sr-only" for="table_size">Table Size</label>
    <b-form-input
        id='table_size'
        v-model="cform.guest_size"
        placeholder="Table Size"
        required
    ></b-form-input>

    <label class="sr-only" for="res-date">Date</label>
    <b-form-input
        id='res-date'
        v-model="cform.date_time"
        placeholder="Date"
        required
    ></b-form-input>
    <br />
    <b-button type="button" @click="create" variant="primary">Submit</b-button>  
  </b-form>
</b-modal>
<!--End of Edit form-->
</div>
</template>

<!--Creating backend methods-->
<script>
import axios from 'axios';

export default {
name: 'Reservations',
data() {
    return {
        reservations: null,
        fields: [
            {key: 'reservation_id', label: 'Reservation Id'},
            {key: 'customer', label: 'Customer Name'},
            {key: 'guest_size', label: 'Reservation Size'},
            {key: 'date', label: 'Date/Time'},
        ],
        activeRes: null,
        activefields: [
            {key: 'phone_number', label: 'Customer Number'},
            {key: 'guest_size', label: 'Guest Size'},
            {key: 'date_time', label: 'Reservation Time'},
        ],

        form:{
            reservation_id: ''
        },

        cform:{
            phone_number: '',
            guest_size: '',
            date_time: ''
        },
    }
},

mounted (){
    this.init();
},

methods: {

    init() {
        axios
          .get('http://localhost:8085/Reservations')
          .then(response => (this.reservations = response.data))
    },

    create() {
    axios
      .put('http://localhost:8085/Reservations/' + this.form.reservation_id, {
        "phone_number": this.cform.phone_number,
        "guest_size": this.cform.guest_size,
        "date_time": this.cform.date_time,
      })
      .then(() => this.init())
      .catch(function (error) {
        console.log(error);
      });
    },

    resetCreateModal() {
    this.cform.phone_number=''
    this.cform.guest_size=''
    this.cform.date_time=''
    },

    deleteRes() { 
      axios
        .post('http://localhost:8085/CancelledReservations/' + this.form.reservation_id)
        .then(() => this.init())
        .catch(function (error) {
          console.log(error);
        });

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