<template>
  <a-modal
      v-model:visible="visible"
      title="Title"
      :confirm-loading="confirmLoading"
      @ok="handleOk"
  >
    <p>{{ modalText }}</p>
  </a-modal>
</template>
<script setup>
import { ref} from 'vue';

const modalText = ref('Content of the modal');
const visible = ref(false);
const confirmLoading = ref(false);

const showModal = () => {
  visible.value = true;
};

const handleOk = () => {
  modalText.value = 'The modal will be closed after two seconds';
  confirmLoading.value = true;
  setTimeout(() => {
    visible.value = false;
    confirmLoading.value = false;
  }, 2000);
};

expose({
  showModal
})
</script>