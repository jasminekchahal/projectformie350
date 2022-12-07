<!-- DONE -->

<template>
  <div class="tables">
    <h2>Tables</h2>
    <br>
    <d>Use this page to manage tables at Jo's Resturant</d>
    <br>
    <br>
    <b-navbar-brand to="/reservations"><b-icon icon="book" variant="warning" style="font-size: 3em; margin-left: 20px;"></b-icon></b-navbar-brand>
        <br><d to="/reservations">Reservations Menu</d><br>
        <br>
        <b-navbar-brand to="/servers"><b-icon icon="person" variant="warning" style="font-size: 3em; margin-left: 12px;"></b-icon></b-navbar-brand>
        <br><d to="/reservations">Servers Menu</d><br>
        <br>
        <br>
        <br>
    <b-button class="add-button" v-b-modal.create-modal>
      <b-icon-plus-circle></b-icon-plus-circle>
    </b-button>

<!--Starting Tables-->
    <b-table striped hover responsive :items="tables" :fields="fields">
        <template #cell(actions)="row">
          <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
            Edit
          </b-button>
        </template>
      </b-table>
<!--Finishing Table table-->

<!--Edit form-->
<b-modal id="edit-modal" title="Edit Table" @hide="resetEditModal" hide-footer>
  <b-form>
    
    <label class="sr-only" for="input-id">Table ID</label>
      <b-form-input
        id='input-id'
        v-model="form.id"
        placeholder="Table ID"
        readonly
      ></b-form-input>

    <label class="sr-only" for="input-table-capacity">Table Capacity</label>
      <b-form-input
          id='input-table-capacity'
          v-model="form.table_capacity"
          placeholder="Table Capacity"
          required
      ></b-form-input>

      <br />
      <b-button type="button" @click="onSave" variant="primary">Save</b-button>
      <b-button type="reset" variant="warning">Reset</b-button>
      <b-button type="button" @click="deleteTable" variant="danger">Remove Table</b-button>
  
    </b-form>
</b-modal>

  <b-modal id="create-modal" title="Create Table" @hide="resetCreateModal" hide-footer>
    <b-form>
      
      <label class="sr-only" for="input-cid">Table ID</label>
        <b-form-input
          id='input-cid'
          v-model="cform.id"
          placeholder="Table ID"
          required
        ></b-form-input>

      <label class="sr-only" for="input-table-ccapacity">Table Capacity</label>
        <b-form-input
            id='input-table-ccapacity'
            v-model="cform.table_capacity"
            placeholder="Table Capacity"
            required
        ></b-form-input>

        <br />
        <b-button type="button" @click="create" variant="primary">Add</b-button>  
      </b-form>
  </b-modal>
<!--End of Edit form-->
  </div>
</template>

<!--Creating backend methods-->
<script>
import axios from 'axios';

export default {
  name: 'Tables',
  data() {
      return {
          tables: null,
          fields: [
              {key: 'id', label: 'Table ID'},
              {key: 'table_capacity', label: 'Table Capacity'},
              {key: 'actions', label: 'Actions'}
          ],

          form:{
              id: '',
              table_capacity: ''
          },

          cform:{
              id: '',
              table_capacity: ''
          },
      }
  },

  mounted (){
      this.init();
  },

  methods: {
      init() {
          axios
            .get('http://localhost:8085/tables')
            .then(response => (this.tables = response.data))
      },

      edit(item, index, button) {
      this.form.id = item.id
      this.form.table_capacity = item.table_capacity
      },

      resetEditModal() {
      this.form.id=''
      this.form.table_capacity=''
      },

      onSave(event) {
      var numId;
      numId = parseInt(this.form.id);
      axios
        .put('http://localhost:8085/tables/' + numId, {
          "id": numId,
          "table_capacity": this.form.table_capacity,
        })
        .then(() => this.init())
        .catch(function (error) {
          console.log(error);
        });
      },

      create() {
          axios
            .post('http://localhost:8085/tables', {
              "id": this.cform.id,
              "table_capacity": this.cform.table_capacity,
            })

            .then(() => {this.init();this.$refs['create-modal'].hide()})
            .catch(function (error) {
              console.log(error);
            });
      },

      resetCreateModal() {
      this.cform.id=''
      this.cform.table_capacity=''
      },

      deleteTable(event) {
        var idDel;
        idDel = parseInt(this.form.id);
        axios
          .delete('http://localhost:8085/tables/' + idDel)
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