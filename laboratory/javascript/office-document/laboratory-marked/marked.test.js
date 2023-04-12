import {marked} from "https://cdnjs.cloudflare.com/ajax/libs/marked/4.3.0/lib/marked.esm.min.js"

const markdown = await Deno.readTextFile('test-data.md');
console.log(JSON.stringify(marked.lexer(markdown)))