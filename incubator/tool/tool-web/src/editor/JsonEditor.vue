<template>
    <div>
        <div id="codeEditor" ref="codeEditor"></div>
    </div>
</template>

<script>
    import JSONEditor from 'jsoneditor/dist/jsoneditor.min.js';

    export default {
        name: "JsonEditor",
        mounted() {
            const container = this.$refs.codeEditor;
            const editor = new JSONEditor(container, {
                mode: 'tree',
                modes: ['code', 'form', 'text', 'tree', 'view', 'preview']
            })
        }
    }
</script>

<style scoped>
    #codeEditor {
        width: 500px;
        height: 500px;
    }
</style>