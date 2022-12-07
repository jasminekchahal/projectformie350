<template>
    <div class="serverReview">
      <h2>Review Servers</h2>
      <br>
    <d>Use this page to give feedback to your server!</d>
    <br>
    <br>
    <b-navbar-brand to="/addServer"><b-icon icon="person-plus" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
        <br><d to="/addServer">Add New Server</d><br>
        <br>
        <b-navbar-brand to="/servers"><b-icon icon="person" variant="warning" style="font-size: 3em; margin-left: 12px;"></b-icon></b-navbar-brand>
        <br><d to="/servers">View/Edit Servers</d><br>
        <br>
        <br>
        <br>

    <!--Starting Servers-->
    <b-table striped hover responsive :items="activeRes" :fields="activefields">
        <template #cell(actions)="row">
          <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
            Accept
          </b-button>
        </template>
      </b-table>
<!--Finishing Servers table-->

<!--Edit form-->
<b-modal id="edit-modal" title="Accept Reservation" @hide="resetEditModal" hide-footer>
  <b-form>
    
    <label class="sr-only" for="input-resId">Reservation ID</label>
      <b-form-input
        id='input-resId'
        v-model="form.reservation_id"
        placeholder="Reservation ID"
        readonly
      ></b-form-input>

    <label class="sr-only" for="input-server-id">Server ID</label>
      <b-form-input
          id='input-server-id'
          v-model="form.server"
          placeholder="Server ID"
          required
      ></b-form-input>

    <label class="sr-only" for="input-table-id">Table ID</label>
      <b-form-input
          id='input-table-id'
          v-model="form.tables"
          placeholder="Table ID"
          required
      ></b-form-input>

    <label class="sr-only" for="input-customer-rating">Customer Rating</label>
      <b-form-input
          id='input-customer-rating'
          v-model="form.customerRating"
          placeholder="Customer Rating"
          required
      ></b-form-input>
      
      <br />
      <b-button type="button" @click="onSave" variant="primary">Submit</b-button>
    </b-form>
</b-modal>
<!--End of Edit form-->



    </div>
</template>


<!--Creating backend methods-->
<script>
import axios from 'axios';

export default {
  name: 'ServerReview',
  data() {
      return {
          activeRes: null,
          activefields: [
              {key: 'reservation_id', label: 'Reservation Id'},
              {key: 'customer.number', label: 'Customer Number'},
              {key: 'guest_size', label: 'Guest Size'},
              {key: 'date_time', label: 'Reservation Time'},
              {key: 'actions', label: 'Actions'}
          ],

          completedRes: null,
          completedfields: [
              {key: 'reservation_id', label: 'Reservation Id'},
              {key: 'customer.number', label: 'Customer Number'},
              {key: 'guest_size', label: 'Guest Size'},
              {key: 'date_time', label: 'Reservation Time'},
              {key: 'server', label: 'Server ID'},
              {key: 'tables', label: 'Table ID'},
              {key: 'completed_time', label: 'Completion Time'},
              {key: 'customerRating', label: 'Customer Rating'},
          ],

          form:{
              reservation_id: '',
              server: '',
              tables: '',
              customerRating: ''
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
            .then(response => (this.activeRes = response.data))
      },

      edit(item, index, button) {
      this.form.reservation_id = item.reservation_id
      this.form.server = item.server
      this.form.tables = item.tables
      this.form.customerRating = item.customerRating
      },

      resetEditModal() {
      this.form.reservation_id=''
      this.form.server=''
      this.form.tables=''
      this.form.customerRating=''
      },

      onSave(event) {
      axios
        .post('http://localhost:8085/CompletedReservations', {
          "reservation_id": this.form.reservation_id,
          "server_id": this.form.server,
          "table_id": this.form.tables,
          "rating": this.form.customerRating,
        })

        .then(() => {this.init();this.$refs['edit-modal'].hide()})
        .catch(function (error) {
          console.log(error);
        });
      },

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
/*STILL NEED TO EDIT THIS SHIT*/
</style>
