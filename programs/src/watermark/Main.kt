package watermark

import java.awt.Color
import java.awt.Transparency.*
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.system.exitProcess

fun main() {
    val imageName = readLineWithQuery("Input the image filename:")
    val image = readImage(imageName)
    checkImage(image)

    val watermarkName = readLineWithQuery("Input the watermark image filename:")
    val watermarkImage = readImage(watermarkName)
    checkWatermark(image, watermarkImage)

    val isAlpha = getAlphaStatus(watermarkImage)
    val isTransparencyColor = getTransparencyStatus(watermarkImage)
    val transparencyColors = getTransparencyColors(isTransparencyColor)
    val weight = getWatermarkWeight()

    var watermarkPosition = listOf(0, 0)
    val positionMethod = readLineWithQuery("Choose the position method (single, grid):")
    checkWatermarkPositionMethod(positionMethod)
    if (positionMethod == "single") {
        val diffX = image.width - watermarkImage.width
        val diffY = image.height - watermarkImage.height
        watermarkPosition = getWatermarkSinglePosition(diffX, diffY)
        checkWatermarkSinglePositionRange(watermarkPosition, diffX, diffY)
    }
    val (wX, wY) = watermarkPosition

    val outputName = readLineWithQuery("Input the output image filename (jpg or png extension):")
    val outputFormat = getOutputFormat(outputName)
    val outputImage = BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_RGB)

    for (x in 0 until image.width) {
        for (y in 0 until image.height) {

            val i = Color(image.getRGB(x, y))
            val w = if (positionMethod == "grid") {
                getWatermarkColorGrid(watermarkImage, isAlpha, x, y)
            } else {
                if (!isOutOfWatermark(watermarkImage, x, y, wX, wY)) {
                    getWatermarkColorSingle(watermarkImage, isAlpha, x, y, wX, wY)
                } else {
                    i
                }
            }

            val color = when {
                (w == i) -> i
                (isAlpha) -> getColorWithAlpha(i, w, weight)
                (isTransparencyColor) -> getColorWithTransparency(i, w, weight, transparencyColors)
                else -> getColorWithWeight(i, w, weight)
            }
            outputImage.setRGB(x, y, color.rgb)
        }
    }

    writeImage(outputImage, outputFormat, outputName)
}

fun readLineWithQuery(message: String): String {
    println(message)
    return readln()
}

fun showError(text: String) {
    println(text)
    exitProcess(0)
}

fun readImage(filename: String): BufferedImage {
    val file = File(filename)
    if (!file.exists()) {
        showError("The file $filename doesn't exist.")
    }
    return ImageIO.read(file)
}

//fun showImageStats(image: BufferedImage) {
//    println("Image file:")
//    println("Width: ${image.width}")
//    println("Height: ${image.height}")
//    println("Number of components: ${image.colorModel.numComponents}")
//    println("Number of color components: ${image.colorModel.numColorComponents}")
//    println("Bits per pixel: ${image.colorModel.pixelSize}")
//    println("Transparency: ${image.transparency}")
//}

fun checkImage(image: BufferedImage) {
    if (image.colorModel.numColorComponents != 3) {
        showError("The number of image color components isn't 3.")
    }
    if (image.colorModel.pixelSize != 24 && image.colorModel.pixelSize != 32) {
        showError("The image isn't 24 or 32-bit.")
    }
}

fun checkWatermark(image: BufferedImage, watermarkImage: BufferedImage) {
    if (watermarkImage.colorModel.numColorComponents != 3) {
        showError("The number of watermark color components isn't 3.")
    }
    if (watermarkImage.colorModel.pixelSize != 24 && watermarkImage.colorModel.pixelSize != 32) {
        showError("The watermark isn't 24 or 32-bit.")
    }
    if (image.width < watermarkImage.width || image.height < watermarkImage.height) {
        showError("The watermark's dimensions are larger.")
    }
}

fun getAlphaStatus(image: BufferedImage): Boolean =
    if (image.transparency == TRANSLUCENT) {
        readLineWithQuery("Do you want to use the watermark's Alpha channel?").lowercase() == "yes"
    } else false

fun getTransparencyStatus(image: BufferedImage): Boolean =
    if (image.transparency != TRANSLUCENT) {
        readLineWithQuery("Do you want to set a transparency color?").lowercase() == "yes"
    } else false

fun getWatermarkWeight(): Int {
    val percentage = readLineWithQuery("Input the watermark transparency percentage (Integer 0-100):")
    if (percentage.toIntOrNull() == null) {
        showError("The transparency percentage isn't an integer number.")
    }
    val weight = percentage.toInt()
    if (weight !in 0..100) {
        showError("The transparency percentage is out of range.")
    }
    return weight
}

fun getTransparencyColors(isTransparencyColor: Boolean): List<Int> {
    if (isTransparencyColor) {
        val input = readLineWithQuery("Input a transparency color ([Red] [Green] [Blue]):").split(" ")
        checkTransparencyColors(input)
        return input.map { it.toInt() }
    }
    return emptyList()
}

fun checkTransparencyColors(list: List<String>) {
    if (list.size != 3 || list.any { it.toIntOrNull() == null } || list.any { it.toInt() < 0 || it.toInt() > 255 }) {
        showError("The transparency color input is invalid.")
    }
}

fun checkWatermarkPositionMethod(positionMethod: String) {
    if (positionMethod != "single" && positionMethod != "grid") {
        showError("The position method input is invalid.")
    }
}

fun getWatermarkSinglePosition(diffX: Int, diffY: Int): List<Int> {
    val input = readLineWithQuery("Input the watermark position ([x 0-$diffX] [y 0-$diffY]):").split(" ")
    checkWatermarkSinglePosition(input)
    return input.map { it.toInt() }
}

fun checkWatermarkSinglePosition(positions: List<String>) {
    if (positions.size != 2 || positions.any { it.toIntOrNull() == null }) {
        showError("The position input is invalid.")
    }
}

fun checkWatermarkSinglePositionRange(positions: List<Int>, diffX: Int, diffY: Int) {
    if(positions[0] !in 0..diffX || positions[1] !in 0..diffY) {
        showError("The position input is out of range.")
    }
}

fun getOutputFormat(filename: String): String {
    val format = filename.split(".").last()
    checkOutputFormat(format)
    return format
}

fun checkOutputFormat(format: String) {
    if (".$format" != ".jpg" && ".$format" != ".png") {
        showError("The output file extension isn't \"jpg\" or \"png\".")
    }
}

fun isOutOfWatermark(image: BufferedImage, x: Int, y: Int, wX: Int, wY: Int): Boolean =
    x !in wX until (wX + image.width) || y !in wY until (wY + image.height)

fun getWatermarkColorSingle(image: BufferedImage, isAlpha: Boolean, x: Int, y: Int, wX: Int, wY: Int): Color =
    Color(image.getRGB(x - wX, y - wY), isAlpha)

fun getWatermarkColorGrid(image: BufferedImage, isAlpha: Boolean, x: Int, y: Int): Color =
    Color(image.getRGB(x % image.width, y % image.height), isAlpha)

fun getColorWithAlpha(i: Color, w: Color, weight: Int): Color =
    if (w.alpha != 255) {
        Color(i.red, i.green, i.blue)
    } else {
        getColorWithWeight(i, w, weight)
    }

fun getColorWithTransparency(i: Color, w: Color, weight: Int, tColors: List<Int>): Color =
    if (w.red == tColors[0] && w.green == tColors[1] && w.blue == tColors[2]) {
        Color(i.red, i.green, i.blue)
    } else {
        getColorWithWeight(i, w, weight)
    }

fun getColorWithWeight(i: Color, w: Color, weight: Int): Color =
    Color(
        (weight * w.red + (100 - weight) * i.red) / 100,
        (weight * w.green + (100 - weight) * i.green) / 100,
        (weight * w.blue + (100 - weight) * i.blue) / 100
    )

fun writeImage(outputImage: BufferedImage, format: String, filename: String) {
    val outputFile = File(filename)
    ImageIO.write(outputImage, format, outputFile)
    println("The watermarked image $filename has been created.")
}