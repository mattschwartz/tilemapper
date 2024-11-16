package com.barelyconscious.tilemapper

import java.awt.BorderLayout
import javax.swing.JFrame

class TileMapEditor(
    private var tileGrid: TileGrid? = null,
    private var palette: Palette? = null,
    var currentBrush: Sprite? = null
) : JFrame() {
    init {
        title = "Tilemapper"
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        layout = BorderLayout()

        val sprites = SpriteLoader.loadSprites("C:\\Users\\cassiius\\Documents\\github\\worlds-cpp\\worlds-cpp\\Sprites")

        tileGrid = TileGrid(40, 23)
        palette = Palette(sprites) {
            currentBrush = it
        }

        add(tileGrid!!, BorderLayout.CENTER)
        add(palette!!, BorderLayout.EAST)

        pack()
        setLocationRelativeTo(null)
        isVisible = true
    }
}
