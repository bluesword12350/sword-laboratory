<template>
  <div id="relational-graph" style="width:90vw; height: 90vh"></div>
</template>

<script setup>
import {onMounted} from "vue";
import G6 from '@antv/g6';
import RelationalGraph from "./relational_graph";

const relationalGraph = new RelationalGraph();
relationalGraph.addNodes([
  {label: '毛发1'},
  {label: '毛发2'},
])

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
  graph.data(relationalGraph.getGraphData());
  graph.render();
})
</script>

<style>
</style>
