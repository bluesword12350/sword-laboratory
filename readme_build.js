let readmeText = "# 目录说明\r";
let rootPath = ".";
let ignoredDirectories = [".git",".idea",".vscode",".settings"]
async function buildCatalog(path,depth) {
  for await (const dirEntry of Deno.readDir(path)) {
    if (!dirEntry.isDirectory) {
      continue
    }
    let dirName = dirEntry.name;
    if (ignoredDirectories.includes(dirName)) {
      continue
    }
    let dirPath = path + '/' + dirName;
    let catalogDescription;
    try {
      catalogDescription = JSON.parse(await Deno.readTextFile( dirPath + "/catalog_description.json"))
    } catch (e) {
      if (e.name !== 'NotFound') {
        console.error(e)
      }
    }
    for (let i = 0; i < depth; i++) {
      readmeText += '  '
    }
    readmeText += `- [${dirName}](${dirPath})${catalogDescription?.description ? `【${catalogDescription.description}】` : ''}\r`
    if (catalogDescription?.hasSubordinate) {
      await buildCatalog(dirPath,depth+1)
    }
  }
}
await buildCatalog(rootPath,0)
Deno.writeTextFileSync("README.md",readmeText)