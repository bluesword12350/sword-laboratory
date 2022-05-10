<script setup>
import {onMounted} from "vue";
import G6 from '@antv/g6';

const data = {
  nodes: [
    {id: '1', label: '毛发1'},
    {id: '2', label: '毛发2'},
  ],
  edges: [
    {
      source: '1', target: '2',
    },
  ]
}

onMounted(() => {
  const container = document.getElementById('relational-graph');
  const graph = new G6.Graph({
    container,
    layout: {
      type: 'gForce',
      linkDistance: 100,
      preventOverlap: true,
      gpuEnabled: true
    },
    fitView: true,
    defaultNode: {
      size: 50,
    },
    defaultEdge: {
      style: {
        endArrow: true,
        stroke: '#888'
      }
    }
  });
  graph.data(data);
  graph.render();
})
</script>

<template>
  <div id="relational-graph" style="width:100vw; height: 100vh"></div>
</template>

<style>
</style>
