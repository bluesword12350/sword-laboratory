<script setup>
import {onMounted} from "vue";
import G6 from '@antv/g6';

const data = {
  nodes: [
    {id: "1", label: '毛发1'},
    {id: "2", label: '毛发2'},
  ],
  edges: [
    {
      source: '1', target: '2',
    },
  ]
}

onMounted(() => {
  const container = document.getElementById('relational-graph');

  const width = container.scrollWidth;
  const height = container.scrollHeight || 500;

  const graph = new G6.Graph({
    container,
    width,
    height,
    layout: {
      type: 'force',
    },
    defaultNode: {
      size: 40,
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
  <div id="relational-graph" style="height: 100%"></div>
</template>

<style>
</style>
