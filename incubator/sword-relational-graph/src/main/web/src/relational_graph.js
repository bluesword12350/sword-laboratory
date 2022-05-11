function RelationalGraph(relationalGraphData) {
    if (relationalGraphData) {
        this.data = relationalGraphData;
    } else {
        this.data = {serialNo: 0, graph: {nodes: [], edges: []}}
    }
}
RelationalGraph.prototype.getGraphData = function () {
    return this.data.graph
}

RelationalGraph.prototype.addNode = function (node){
    node.id = String(this.data.serialNo++)
    this.data.graph.nodes.push(node);
}
RelationalGraph.prototype.addNodes = function (nodes) {
    for (const key in nodes) {
        this.addNode(nodes[key])
    }
}
RelationalGraph.prototype.addEdge = function (edge){
    this.data.graph.edges.push(edge)
}
RelationalGraph.prototype.addEdges = function (edges){
    for (const key in edges) {
        this.addEdge(edges[key])
    }
}

export default RelationalGraph