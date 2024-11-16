package com.barelyconscious.tilemapper

import java.io.File
import javax.swing.ImageIcon

object SpriteLoader {
    fun loadSprites(dirPath: String): List<Sprite> {
        val sprites = mutableListOf<Sprite>()
        val directory = File(dirPath)

        if (!directory.exists() || !directory.isDirectory){
            throw IllegalArgumentException("Invalid directory path: $dirPath")
        }

        val pngFiles = directory.listFiles { _, name ->
            name.lowercase().endsWith(".png")
        } ?: arrayOf()

        for (file in pngFiles) {
            val spriteName = file.nameWithoutExtension
            val imageIcon = ImageIcon(file.absolutePath)
            val sprite = Sprite(spriteName, imageIcon)
            sprites.add(sprite)
        }

        return sprites
    }
}
