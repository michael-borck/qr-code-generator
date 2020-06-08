package com.piotrjanczyk.qrcodegenerator.web

data class QrCodeDefinition(
  val data: String,
  val imageFormat: ImageFormat = ImageFormat.PNG,
  val version: Int? = null,
  val errorCorrection: ErrorCorrection = DEFAULT_ERROR_CORRECTION,
  val foregroundColor: String = DEFAULT_FOREGROUND_COLOR,
  val backgroundColor: String = DEFAULT_BACKGROUND_COLOR,
  val boxSize: Int = DEFAULT_BOX_SIZE,
  val borderSize: Int = DEFAULT_BORDER_SIZE
) {
  val hasCustomVersion: Boolean get() = version != null
  val hasCustomErrorCorrection: Boolean get() = errorCorrection != DEFAULT_ERROR_CORRECTION
  val hasCustomForegroundColor: Boolean get() = foregroundColor != DEFAULT_FOREGROUND_COLOR
  val hasCustomBackgroundColor: Boolean get() = backgroundColor != DEFAULT_BACKGROUND_COLOR
  val hasCustomBoxSize: Boolean get() = boxSize != DEFAULT_BOX_SIZE
  val hasCustomBorderSize: Boolean get() = borderSize != DEFAULT_BORDER_SIZE

  companion object {
    val DEFAULT_ERROR_CORRECTION = ErrorCorrection.MEDIUM
    const val DEFAULT_FOREGROUND_COLOR = "#000000"
    const val DEFAULT_BACKGROUND_COLOR = "#ffffff"
    const val DEFAULT_BOX_SIZE = 10
    const val DEFAULT_BORDER_SIZE = 4

    fun build(
      data: String,
      imageFormat: ImageFormat? = null,
      version: Int? = null,
      errorCorrection: ErrorCorrection? = null,
      foregroundColor: String?,
      backgroundColor: String? = null,
      boxSize: Int? = null,
      border: Int? = null
    ): QrCodeDefinition =
      QrCodeDefinition(
        data = data,
        imageFormat = imageFormat ?: ImageFormat.PNG,
        version = version,
        errorCorrection = errorCorrection ?: DEFAULT_ERROR_CORRECTION,
        foregroundColor = foregroundColor ?: DEFAULT_FOREGROUND_COLOR,
        backgroundColor = backgroundColor ?: DEFAULT_BACKGROUND_COLOR,
        boxSize = boxSize ?: DEFAULT_BOX_SIZE,
        borderSize = border ?: DEFAULT_BORDER_SIZE
      )
  }
}

enum class ImageFormat {
  PNG,
  SVG
}

enum class ErrorCorrection {
  LOW,
  MEDIUM,
  QUARTILE,
  HIGH
}
