<template>
  <div>
    <a-button type="primary" @click="showModal">Open Modal with async logic</a-button>
    <modal-component ref="modalComponent"/>
  </div>
</template>
<script setup>
import ModalComponent from "../component/ModalComponent.vue"
import {ref} from "vue"

const modalComponent = ref(null)

const showModal = function () {
  modalComponent.value.showModal()
}
</script>