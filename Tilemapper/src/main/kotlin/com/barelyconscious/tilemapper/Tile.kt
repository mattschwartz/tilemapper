package com.barelyconscious.tilemapper

import java.awt.Color
import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.SwingUtilities

class Tile(
    private var sprite: Sprite? = null
) : JLabel() {
    init {
        preferredSize = Dimension(32, 32)
        border = BorderFactory.createLineBorder(Color.GRAY)
        isOpaque = true

        addMouseListener(object : MouseAdapter() {
            override fun mouseReleased(e: MouseEvent?) {
                val editor = SwingUtilities.getWindowAncestor(this@Tile) as TileMapEditor
                val brush = editor.currentBrush
                if (brush != null) {
                    icon = brush.imageIcon
                    sprite = brush
                }
            }
        })
    }
}
