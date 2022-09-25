import fs from "fs";
import path from "path";

const RESOURCEDIR = path.resolve("../src/main/resources/assets/ccraft");

const MODELSDIR = path.join(RESOURCEDIR, "models");
const BLOCKSTATESDIR = path.join(RESOURCEDIR, "blockstates");
const TEXTURESDIR = path.join(RESOURCEDIR, "textures");

const MISSING_BLOCKSTATES: string[] = [];
const INVALID_TEXTURES: string[] = [];

fs.readdirSync(path.join(MODELSDIR, "item")).forEach((itemmodel) => {
  if (itemmodel.endsWith(".json")) {
    const model = require(path.join(MODELSDIR, "item", itemmodel));

    Object.values(model.textures).forEach((texture_name) => {
      const extracted_texture_name = (texture_name as string).split(":")[1];
      const texture_path = path.join(
        TEXTURESDIR,
        extracted_texture_name + ".png"
      );

      if (!fs.existsSync(texture_path)) {
        INVALID_TEXTURES.push(itemmodel + "  |  " + extracted_texture_name);
      }
    });
  }
});

fs.readdirSync(path.join(MODELSDIR, "block")).forEach((blockmodel) => {
  if (blockmodel.endsWith(".json")) {
    if (
      !fs.existsSync(path.join(BLOCKSTATESDIR, blockmodel)) &&
      !blockmodel.includes("_running")
    ) {
      MISSING_BLOCKSTATES.push(path.basename(blockmodel));
    }

    const model = require(path.join(MODELSDIR, "block", blockmodel));

    Object.values(model.textures).forEach((texture_name) => {
      const extracted_texture_name = (texture_name as string).split(":")[1];
      const texture_path = path.join(
        TEXTURESDIR,
        extracted_texture_name + ".png"
      );

      if (!fs.existsSync(texture_path)) {
        INVALID_TEXTURES.push(blockmodel + "  |  " + extracted_texture_name);
      }
    });
  }
});

console.log("MISSING BLOCKSTATES:\n" + MISSING_BLOCKSTATES.join("\n") + "\n");
console.log("INVALID TEXTURES:\n" + INVALID_TEXTURES.join("\n"));
