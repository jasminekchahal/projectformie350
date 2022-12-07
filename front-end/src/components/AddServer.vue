
<!-- on admin side-->

<!--Servers UI portion-->
<template>
    <div class="addServer">
      <h2>Add New Servers</h2>
  
      <br>
      <d>Use this page when you need to add a new hire!</d>
  
      <br>
      <br>
      <b-navbar-brand to="/reservations"><b-icon icon="book" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
          <br><d to="/reservations">Reservations Menu</d><br>
          <br>
          <b-navbar-brand to="/tables"><b-icon icon="table" variant="warning" style="font-size: 3em; margin-left: 12px;"></b-icon></b-navbar-brand>
          <br><d to="/reservations"> Tables Menu</d><br>
          <br>
          <br>
          <br>
        
        <b-button class="add-button" v-b-modal.create-modal>
        <b-icon-plus-circle></b-icon-plus-circle>
        </b-button>
  
        <b-table striped hover responsive :items="servers" :fields="fields">
      <template #cell(actions)="row">
        <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
          Edit
        </b-button>
      </template>
    </b-table>


    <b-modal id="edit-modal" title="Edit Server" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-id">Server ID</label>
        <b-form-input
          id='input-id'
          v-model="form.id"
          placeholder="Server ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-name">Server Name</label>
        <b-form-input
          id='input-name'
          v-model="form.name"
          placeholder="Server Name"
          required
        ></b-form-input>

        <label class="sr-only" for="input-availability">Availability</label>
        <b-form-input
          id="input-availability"
          v-model="form.availability"
          placeholder="Availability"
          required
        ></b-form-input>

        <label class="sr-only" for="input-serving-capacity">Serving Capacity</label>
        <b-form-input
          id="input-serving-capacity"
          v-model="form.serving_capacity"
          placeholder="Serving Capacity"
          required
        ></b-form-input>
        
        <br />
        <b-button type="button" @click="onSave" variant="primary">Save</b-button>
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" @click="deleteServer" variant="danger">Remove Server</b-button>
      </b-form>

    </b-modal>

    <b-modal id="create-modal" title="Create Server" @hide="resetCreateModal" hide-footer>
      <b-form>
      
        <label class="sr-only" for="input-cid">Server ID</label>
        <b-form-input
          id='input-cid'
          v-model="cform.id"
          placeholder="Server ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-cname">Server Name</label>
        <b-form-input
          id='input-cname'
          v-model="cform.name"
          placeholder="Server Name"
          required
        ></b-form-input>

        <label class="sr-only" for="input-cavailability">Availability</label>
        <b-form-input
          id="input-cavailability"
          v-model="cform.availability"
          placeholder="Availability"
          required
        ></b-form-input>

        <label class="sr-only" for="input-cserving-capacity">Serving Capacity</label>
        <b-form-input
          id="input-cserving-capacity"
          v-model="cform.serving_capacity"
          placeholder="Serving Capacity"
          required
        ></b-form-input>

        <br />
        <b-button type="button" @click="create" variant="primary">Add</b-button>  
      </b-form>
    </b-modal>
    </div>
  </template>

<script>
import axios from 'axios';

export default {
  name: 'AddServer',
  data () {
      return{
          servers: null,
          fields: [
              {key: 'id', label: 'Server ID', sortable: true},
              {key: 'name', label: 'Name', sortable: true},
              {key: 'availability', label: 'Availability', sortable: true},
              {key: 'serving_capacity', label: 'Serving Capacity', sortable: true},
              {key: 'actions', label: 'Actions'}
          ],

          form:{
              id: '',
              name: '',
              availability: '',
              serving_capacity: ''
          },

          cform:{
              id: '',
              name: '',
              availability: '',
              serving_capacity: ''
          },

      }
  },

  mounted () {
      this.init();
  },

  methods: {
      init() {
          axios
            .get('http://localhost:8085/servers')
            .then(response => (this.servers = response.data))
      },

      edit(item, index, button) {
      this.form.id = item.id
      this.form.name = item.name
      this.form.availability = item.availability
      this.form.serving_capacity = item.serving_capacity
      },

      resetEditModal() {
      this.form.id=''
      this.form.name=''
      this.form.availability=''
      this.form.serving_capacity=''
      },

      onSave(event) {
      var numId;
      numId = parseInt(this.form.id);
      axios
        .put('http://localhost:8085/servers/' + numId, {
          "id": numId,
          "name": this.form.name,
          "availability": this.form.availability,
          "serving_capacity": this.form.serving_capacity,
        })
        .then(() => this.init())
        .catch(function (error) {
          console.log(error);
        });
      },

      create() {
        axios
          .post('http://localhost:8085/servers', {
          "id": this.cform.id,
          "name": this.cform.name,
          "availability": this.cform.availability,
          "serving_capacity": this.cform.serving_capacity,
          })

          .then(() => {this.init();this.$refs['create-modal'].hide()})
          .catch(function (error) {
            console.log(error);
          });
    },

    resetCreateModal() {
    this.cform.id=''
    this.cform.name=''
    this.cform.availability=''
    this.cform.serving_capacity=''
    },

    deleteTable(event) {
        var idDel;
        idDel = parseInt(this.form.id);
        axios
          .delete('http://localhost:8085/servers/' + idDel)
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

