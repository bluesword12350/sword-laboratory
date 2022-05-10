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
  const graph = new G6.Graph({
    container,
    width:container.scrollWidth,
    height:container.scrollHeight || 500,
    layout: {
      type: 'gForce',
      linkDistance: 100,
      preventOverlap: true
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
  <div id="relational-graph" style="height: 100%"></div>
</template>

<style>
</style>
