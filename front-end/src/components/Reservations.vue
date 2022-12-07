<!-- on admin side-->

<template>
    <div class="reservations">
        <h2>Reservations</h2>

        <br />
        <h2>Active Reservations</h2>
        <b-table striped hover responsive :items="activeRes" :fields="activefields">
      </b-table>

      <br />
      <h2>Completed Reservations</h2>
      <b-table striped hover responsive :items="completedRes" :fields="completedfields">
      </b-table>
      
      <br />
      <h2>Cancelled Reservations</h2>
      <b-table striped hover responsive :items="cancelledRes" :fields="cancelledfields">
      </b-table>
    </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Reservations',
  data() {
      return {
          activeRes: null,
          activefields: [
              {key: 'reservation_id', label: 'Reservation Id'},
              {key: 'customer.number', label: 'Customer Number'},
              {key: 'guest_size', label: 'Guest Size'},
              {key: 'date_time', label: 'Reservation Time'},
          ],

          completedRes: null,
          completedfields: [
              {key: 'reservation_id', label: 'Reservation Id'},
              {key: 'customer.number', label: 'Customer Number'},
              {key: 'guest_size', label: 'Guest Size'},
              {key: 'date_time', label: 'Reservation Time'},
              {key: 'server.id', label: 'Server ID'},
              {key: 'tables.id', label: 'Table ID'},
              {key: 'completed_time', label: 'Completion Time'},
              {key: 'customerRating.rating', label: 'Customer Rating'},
          ],

          cancelledRes: null,
          cancelledfields: [
              {key: 'reservation_id', label: 'Reservation Id'},
              {key: 'customer.number', label: 'Customer Number'},
              {key: 'guest_size', label: 'Guest Size'},
              {key: 'date_time', label: 'Reservation Time'},
              {key: 'date_cancelled', label: 'Cancellation Time'},
          ],
      }
  },

  mounted (){
      this.initActive();
      this.initCompleted();
      this.initCancelled();
  },

  methods: {
      initActive() {
          axios
            .get('http://localhost:8085/Reservations')
            .then(response => (this.activeRes = response.data))
      },

      initCompleted() {
          axios
            .get('http://localhost:8085/CompletedReservations')
            .then(response => (this.completedRes = response.data))
      },

      initCancelled() {
          axios
            .get('http://localhost:8085/CancelledReservations')
            .then(response => (this.cancelledRes = response.data))
      },

  }
}
</script>